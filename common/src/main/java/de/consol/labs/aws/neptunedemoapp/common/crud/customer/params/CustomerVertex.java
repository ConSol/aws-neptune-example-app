package de.consol.labs.aws.neptunedemoapp.common.crud.customer.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractVertexAdapter;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public class CustomerVertex extends AbstractVertexAdapter {
    public CustomerVertex(final Vertex vertex) {
        super(vertex);
    }
}
