package de.consol.labs.aws.neptunedemoapp.common.crud.absence.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractVertexAdapter;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public class AbsenceVertex extends AbstractVertexAdapter {
    public AbsenceVertex(final Vertex vertex) {
        super(vertex);
    }
}
