package de.consol.labs.aws.neptunedemoapp.common.crud;

import org.apache.tinkerpop.gremlin.structure.*;

import java.util.Iterator;

public abstract class AbstractEdgeAdapter implements Edge {

    protected final Edge edge;

    protected AbstractEdgeAdapter(final Edge edge) {
        this.edge = edge;
    }

    public Edge getEdge() {
        return edge;
    }

    @Override
    public Iterator<Vertex> vertices(final Direction direction) {
        return getEdge().vertices(direction);
    }

    @Override
    public Object id() {
        return getEdge().id();
    }

    @Override
    public String label() {
        return getEdge().label();
    }

    @Override
    public Graph graph() {
        return getEdge().graph();
    }

    @Override
    public <V> Property<V> property(final String key, final V value) {
        return getEdge().property(key, value);
    }

    @Override
    public void remove() {
        getEdge().remove();
    }

    @Override
    public <V> Iterator<Property<V>> properties(final String... propertyKeys) {
        return getEdge().properties(propertyKeys);
    }
}
