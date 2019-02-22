package de.consol.labs.aws.neptunedemoapp.common.crud.customer;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.Label;
import de.consol.labs.aws.neptunedemoapp.common.crud.customer.params.CustomerModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.customer.params.CustomerVertex;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.function.Function;

public class CustomerCrudController extends AbstractCrudController<CustomerModel, CustomerVertex, CustomerModel, CustomerModel, CustomerModel> {

    @Override
    protected String getLabel() {
        return Label.Vertex.CUSTOMER;
    }

    @Override
    protected Function<Vertex, CustomerVertex> getVertexConverter() {
        return CustomerVertex::new;
    }
}

