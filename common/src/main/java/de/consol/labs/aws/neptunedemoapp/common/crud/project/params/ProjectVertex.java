package de.consol.labs.aws.neptunedemoapp.common.crud.project.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractVertexAdapter;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public class ProjectVertex extends AbstractVertexAdapter {
    public ProjectVertex(final Vertex vertex) {
        super(vertex);
    }
}
