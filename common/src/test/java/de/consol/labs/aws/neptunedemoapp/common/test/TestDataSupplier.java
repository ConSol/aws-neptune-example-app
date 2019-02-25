package de.consol.labs.aws.neptunedemoapp.common.test;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;

public interface TestDataSupplier {
    void fillGraph(final GraphTraversalSource g);
}
