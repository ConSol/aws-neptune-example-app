package de.consol.labs.aws.neptunedemoapp.runadhocquery;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import de.consol.labs.aws.neptunedemoapp.common.crud.Label;
import de.consol.labs.aws.neptunedemoapp.common.remote.RemoteClusterAdapter;
import de.consol.labs.aws.neptunedemoapp.common.remote.RemoteConnectionSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tinkerpop.gremlin.process.traversal.P;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;

import java.util.List;
import java.util.Map;

import static org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__.*;

public class RunAdHocQueryHandler implements RequestHandler<QueryParameters, List<Map<Object, Object>>> {

    private static final Logger LOG = LogManager.getLogger(RunAdHocQueryHandler.class);

    @Override
    public List<Map<Object, Object>> handleRequest(final QueryParameters parameters, final Context context) {
        final RemoteConnectionSettings settings = new RemoteConnectionSettings()
                .setEndpoint(System.getenv(EnvironmentVariable.NEPTUNE_ENDPOINT))
                .setPort(Integer.parseInt(System.getenv(EnvironmentVariable.NEPTUNE_PORT)))
                .setEnableSsl(true)
                .setKeyCertChainFile(getClass().getClassLoader().getResource("SFSRootCAG2.pem").getFile());
        try (final RemoteClusterAdapter adapter = new RemoteClusterAdapter(settings)) {
            try (final GraphTraversalSource g = adapter.getGraphTraversalSource()) {
                final long availableFrom = parameters.getAvailableFrom();
                final long availableTo = parameters.getAvailableTo();
                return g.V()
                        .hasLabel(Label.Vertex.EMPLOYEE)
                        .and(
                                out("has")
                                        .hasLabel(Label.Vertex.SKILL)
                                        .and(
                                                or(
                                                        has("name", parameters.getSkill1()),
                                                        has("name", parameters.getSkill2()),
                                                        has("name", parameters.getSkill3())
                                                )
                                        )
                                        .count()
                                        .is(P.gte(3))
                        )
                        .and(
                                out("has")
                                        .hasLabel(Label.Vertex.CERTIFICATE)
                                        .has("name", parameters.getCertificate())
                        )
                        .and(
                                out("workOn")
                                        .in("order")
                                        .hasLabel(Label.Vertex.CUSTOMER)
                                        .has("name", parameters.getCustomer())
                        )
                        .and(
                                not(
                                        out("has")
                                                .hasLabel(Label.Vertex.ABSENCE)
                                                .and(
                                                        or(
                                                                has("fromInclusive", P.between(availableFrom, availableTo)),
                                                                has("toInclusive", P.between(availableFrom, availableTo)),
                                                                and(
                                                                        has("fromInclusive", P.lte(availableFrom)),
                                                                        has("toInclusive", P.gte(availableTo))
                                                                )
                                                        )
                                                )
                                )
                        )
                        .valueMap()
                        .toList();
            } catch (final Exception e) {
                LOG.error(e.getMessage(), e);
                throw new RuntimeException(e);
            }
        }
    }
}
