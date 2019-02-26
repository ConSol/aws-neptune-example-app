package de.consol.labs.aws.neptunedemoapp.reademployee;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import de.consol.labs.aws.neptunedemoapp.common.crud.Label;
import de.consol.labs.aws.neptunedemoapp.common.crud.employee.params.EmployeeId;
import de.consol.labs.aws.neptunedemoapp.common.remote.RemoteClusterAdapter;
import de.consol.labs.aws.neptunedemoapp.common.remote.RemoteConnectionSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class ReadEmployeeHandler implements RequestHandler<EmployeeId, Map<Object, Object>> {

    private static final Logger LOG = LogManager.getLogger(ReadEmployeeHandler.class);

    @Override
    public Map<Object, Object> handleRequest(final EmployeeId employeeId, final Context context) {
        final RemoteConnectionSettings settings = new RemoteConnectionSettings()
                .setEndpoint(System.getenv(EnvironmentVariable.NEPTUNE_ENDPOINT))
                .setPort(Integer.parseInt(System.getenv(EnvironmentVariable.NEPTUNE_PORT)))
                .setEnableSsl(true)
                .setKeyCertChainFile(getClass().getClassLoader().getResource("SFSRootCAG2.pem").getFile());
        try (final RemoteClusterAdapter adapter = new RemoteClusterAdapter(settings)) {
            try (final GraphTraversalSource g = adapter.getGraphTraversalSource()) {
                final Optional<Map<Object, Object>> employeeProperties = g.V()
                        .hasLabel(Label.Vertex.EMPLOYEE)
                        .has("id", employeeId.getId())
                        .valueMap()
                        .tryNext();
                if (!employeeProperties.isPresent()) {
                    LOG.info("could not find employee with ID {}", employeeId.getId());
                    return Collections.emptyMap();
                }
                return employeeProperties.get();
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
