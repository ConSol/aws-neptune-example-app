package de.consol.labs.aws.neptunedemoapp.common.crud.edge;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractEdgeAdapter;
import org.apache.tinkerpop.gremlin.structure.Edge;

public class Customer2ProjectEdge extends AbstractEdgeAdapter {
    public Customer2ProjectEdge(final Edge edge) {
        super(edge);
    }
}
