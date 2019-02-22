package de.consol.labs.aws.neptunedemoapp.common.crud.employee.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractVertexAdapter;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public class EmployeeVertex extends AbstractVertexAdapter {
    public EmployeeVertex(final Vertex vertex) {
        super(vertex);
    }
}
