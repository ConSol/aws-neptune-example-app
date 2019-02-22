package de.consol.labs.aws.neptunedemoapp.common.crud.school;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.Label;
import de.consol.labs.aws.neptunedemoapp.common.crud.school.params.SchoolModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.school.params.SchoolVertex;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.function.Function;

public class SchoolCrudController extends AbstractCrudController<SchoolModel, SchoolVertex, SchoolModel, SchoolModel, SchoolModel> {

    @Override
    protected String getLabel() {
        return Label.Vertex.SCHOOL;
    }

    @Override
    protected Function<Vertex, SchoolVertex> getVertexConverter() {
        return SchoolVertex::new;
    }
}
