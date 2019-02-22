package de.consol.labs.aws.neptunedemoapp.common.crud;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.util.function.TriFunction;

import java.util.Map;

public final class PropertyGraphUtils {

    private PropertyGraphUtils() {
    }

    public static <T1, T2> GraphTraversal<T1, T2> setProperties(final GraphTraversal<T1, T2> traversal, final Map<String, Object> properties) {
        return applyOperation(traversal, properties, GraphTraversal::property);
    }

    public static <T1, T2> GraphTraversal<T1, T2> hasProperties(final GraphTraversal<T1, T2> traversal, final Map<String, Object> properties) {
        return applyOperation(traversal, properties, GraphTraversal::has);
    }

    public static <T1, T2> GraphTraversal<T1, T2> applyOperation(
            GraphTraversal<T1, T2> traversal,
            final Map<String, Object> properties,
            final TriFunction<GraphTraversal<T1, T2>, String, Object, GraphTraversal<T1, T2>> operation
    ) {
        for (final Map.Entry<String, Object> kv : properties.entrySet()) {
            traversal = operation.apply(traversal, kv.getKey(), kv.getValue());
        }
        return traversal;
    }
}
