package de.consol.labs.aws.neptunedemoapp.common.crud.school.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractVertexAdapter;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public class SchoolVertex extends AbstractVertexAdapter {
    public SchoolVertex(final Vertex vertex) {
        super(vertex);
    }
}
