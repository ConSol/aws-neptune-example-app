package de.consol.labs.aws.neptunedemoapp.common.crud.edge;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractEdgeAdapter;
import org.apache.tinkerpop.gremlin.structure.Edge;

public class Employee2AbsenceEdge extends AbstractEdgeAdapter {
    public Employee2AbsenceEdge(final Edge edge) {
        super(edge);
    }
}
