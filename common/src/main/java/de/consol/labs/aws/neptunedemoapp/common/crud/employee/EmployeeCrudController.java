package de.consol.labs.aws.neptunedemoapp.common.crud.employee;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.Label;
import de.consol.labs.aws.neptunedemoapp.common.crud.employee.params.EmployeeId;
import de.consol.labs.aws.neptunedemoapp.common.crud.employee.params.EmployeeModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.employee.params.EmployeeVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.employee.params.UpdateEmployeeRequest;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.function.Function;

public class EmployeeCrudController extends AbstractCrudController<EmployeeModel, EmployeeVertex, EmployeeModel, EmployeeId, UpdateEmployeeRequest> {

    @Override
    protected String getLabel() {
        return Label.Vertex.EMPLOYEE;
    }

    @Override
    protected Function<Vertex, EmployeeVertex> getVertexConverter() {
        return EmployeeVertex::new;
    }
}
