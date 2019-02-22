package de.consol.labs.aws.neptunedemoapp.common.crud.edge;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractEdgeAdapter;
import org.apache.tinkerpop.gremlin.structure.Edge;

public class Employee2DegreeEdge extends AbstractEdgeAdapter {
    public Employee2DegreeEdge(final Edge edge) {
        super(edge);
    }
}
