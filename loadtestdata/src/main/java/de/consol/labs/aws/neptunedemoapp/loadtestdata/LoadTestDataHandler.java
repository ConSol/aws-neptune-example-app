package de.consol.labs.aws.neptunedemoapp.loadtestdata;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import de.consol.labs.aws.neptunedemoapp.common.remote.RemoteClusterAdapter;
import de.consol.labs.aws.neptunedemoapp.common.remote.RemoteConnectionSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;

public class LoadTestDataHandler implements RequestHandler<Void, Void> {

    private static final Logger LOG = LogManager.getLogger(LoadTestDataHandler.class);

    @Override
    public Void handleRequest(final Void voidParameter, final Context context) {
        final RemoteConnectionSettings settings = new RemoteConnectionSettings()
                .setEndpoint(System.getenv(EnvironmentVariable.NEPTUNE_ENDPOINT))
                .setPort(Integer.parseInt(System.getenv(EnvironmentVariable.NEPTUNE_PORT)))
                .setEnableSsl(true)
                .setKeyCertChainFile(getClass().getClassLoader().getResource("SFSRootCAG2.pem").getFile());
        try (final RemoteClusterAdapter adapter = new RemoteClusterAdapter(settings)) {
            try (final GraphTraversalSource g = adapter.getGraphTraversalSource()) {
                final TestData data = new TestData();
                data.fillGraph(g);
                return null;
            } catch (final Exception e) {
                LOG.error(e.getMessage(), e);
                throw new RuntimeException(e);
            }
        }
    }
}
