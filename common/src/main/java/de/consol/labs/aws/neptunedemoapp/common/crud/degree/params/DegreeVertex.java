package de.consol.labs.aws.neptunedemoapp.common.crud.degree.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractVertexAdapter;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public class DegreeVertex extends AbstractVertexAdapter {
    public DegreeVertex(final Vertex vertex) {
        super(vertex);
    }
}
