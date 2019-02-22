package de.consol.labs.aws.neptunedemoapp.common.crud.degree;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.Label;
import de.consol.labs.aws.neptunedemoapp.common.crud.degree.params.DegreeModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.degree.params.DegreeVertex;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.function.Function;

public class DegreeCrudController extends AbstractCrudController<DegreeModel, DegreeVertex, DegreeModel, DegreeModel, DegreeModel> {

    @Override
    protected String getLabel() {
        return Label.Vertex.DEGREE;
    }

    @Override
    protected Function<Vertex, DegreeVertex> getVertexConverter() {
        return DegreeVertex::new;
    }
}
