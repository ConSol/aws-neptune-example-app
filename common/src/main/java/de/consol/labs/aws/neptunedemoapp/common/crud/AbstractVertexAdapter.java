package de.consol.labs.aws.neptunedemoapp.common.crud;

import org.apache.tinkerpop.gremlin.structure.*;

import java.util.Iterator;

public abstract class AbstractVertexAdapter implements Vertex {

    protected final Vertex vertex;

    public AbstractVertexAdapter(final Vertex vertex) {
        this.vertex = vertex;
    }

    public Vertex getVertex() {
        return vertex;
    }

    @Override
    public Edge addEdge(final String label, final Vertex inVertex, final Object... keyValues) {
        return getVertex().addEdge(label, inVertex, keyValues);
    }

    @Override
    public <V> VertexProperty<V> property(final VertexProperty.Cardinality cardinality, final String key, final V value, final Object... keyValues) {
        return getVertex().property(cardinality, key, value, keyValues);
    }

    @Override
    public Iterator<Edge> edges(final Direction direction, final String... edgeLabels) {
        return getVertex().edges(direction, edgeLabels);
    }

    @Override
    public Iterator<Vertex> vertices(final Direction direction, final String... edgeLabels) {
        return getVertex().vertices(direction, edgeLabels);
    }

    @Override
    public Object id() {
        return getVertex().id();
    }

    @Override
    public String label() {
        return getVertex().label();
    }

    @Override
    public Graph graph() {
        return getVertex().graph();
    }

    @Override
    public void remove() {
        getVertex().remove();
    }

    @Override
    public <V> Iterator<VertexProperty<V>> properties(final String... propertyKeys) {
        return getVertex().properties(propertyKeys);
    }
}
