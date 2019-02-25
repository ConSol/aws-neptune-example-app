package de.consol.labs.aws.neptunedemoapp.common.remote;

import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.remote.DriverRemoteConnection;
import org.apache.tinkerpop.gremlin.process.traversal.AnonymousTraversalSource;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;

public class RemoteClusterAdapter implements AutoCloseable {

    private final Cluster cluster;

    public RemoteClusterAdapter(final RemoteConnectionSettings connectionSettings) {
        final Cluster.Builder builder = Cluster.build()
                .addContactPoint(connectionSettings.getEndpoint())
                .port(connectionSettings.getPort());
        if (connectionSettings.isEnableSsl()) {
            builder.enableSsl(connectionSettings.isEnableSsl());
            builder.keyCertChainFile(connectionSettings.getKeyCertChainFile());
        }
        cluster = builder.create();
    }

    public GraphTraversalSource getGraphTraversalSource() {
        return AnonymousTraversalSource.traversal().withRemote(DriverRemoteConnection.using(cluster));
    }

    @Override
    public void close() {
        cluster.close();
    }
}
