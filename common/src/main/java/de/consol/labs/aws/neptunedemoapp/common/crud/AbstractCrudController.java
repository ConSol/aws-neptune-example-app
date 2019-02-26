package de.consol.labs.aws.neptunedemoapp.common.crud;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Mapper;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static org.apache.tinkerpop.gremlin.structure.VertexProperty.Cardinality.single;

public abstract class AbstractCrudController<CreateParamsType, CustomVertexType extends Vertex, ReadReturnType, IdParamType, UpdateParamsType> {

    private final Mapper mapper = new Mapper();

    public CustomVertexType create(final GraphTraversalSource g, final CreateParamsType params) {
        GraphTraversal<Vertex, Vertex> traversal = g.addV(getLabel());
        traversal = setVertexProperties(traversal, getMapper().object2Properties(params));
        final Vertex v = traversal.next();
        return getVertexConverter().apply(v);
    }

    public Optional<ReadReturnType> read(final GraphTraversalSource g, final IdParamType id, final Class<ReadReturnType> targetClass) {
        return find(g, id).map(v -> mapVertex(v, targetClass));
    }

    public Optional<CustomVertexType> find(final GraphTraversalSource g, final IdParamType id) {
        return findBy(g, id).tryNext().map(v -> getVertexConverter().apply(v));
    }

    public CustomVertexType update(final GraphTraversalSource g, final IdParamType id, final UpdateParamsType newProperties) {
        GraphTraversal<Vertex, Vertex> traversal = findBy(g, id);
        traversal = setVertexProperties(traversal, getMapper().object2Properties(newProperties));
        final Vertex v = traversal.next();
        return getVertexConverter().apply(v);
    }

    public void delete(final GraphTraversalSource g, final IdParamType id) {
        findBy(g, id).drop().toList();
    }

    protected <T> T mapVertex(final CustomVertexType v, final Class<T> targetClass) {
        final Map<String, Object> properties = new HashMap<>();
        v.properties().forEachRemaining(p -> properties.put(p.key(), p.value()));
        return getMapper().properties2Object(properties, targetClass);
    }

    protected GraphTraversal<Vertex, Vertex> findBy(final GraphTraversalSource g, final Object by) {
        return findByProperties(g, getMapper().object2Properties(by));
    }

    protected GraphTraversal<Vertex, Vertex> findByProperties(final GraphTraversalSource g, final Map<String, Object> properties) {
        GraphTraversal<Vertex, Vertex> t = g.V().hasLabel(getLabel());
        for (final Map.Entry<String, Object> kv : properties.entrySet()) {
            t = t.has(kv.getKey(), kv.getValue());
        }
        return t;
    }

    protected abstract String getLabel();

    protected abstract Function<Vertex, CustomVertexType> getVertexConverter();

    protected Mapper getMapper() {
        return mapper;
    }

    private static GraphTraversal<Vertex, Vertex> setVertexProperties(GraphTraversal<Vertex, Vertex> traversal, final Map<String, Object> properties) {
        for (final Map.Entry<String, Object> kv : properties.entrySet()) {
            traversal = traversal.property(single, kv.getKey(), kv.getValue());
        }
        return traversal;
    }
}
