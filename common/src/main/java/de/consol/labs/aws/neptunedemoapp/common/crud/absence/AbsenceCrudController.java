package de.consol.labs.aws.neptunedemoapp.common.crud.absence;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.Label;
import de.consol.labs.aws.neptunedemoapp.common.crud.absence.params.AbsenceId;
import de.consol.labs.aws.neptunedemoapp.common.crud.absence.params.AbsenceModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.absence.params.AbsenceVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.absence.params.UpdateAbsenceRequest;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.function.Function;

public class AbsenceCrudController extends AbstractCrudController<AbsenceModel, AbsenceVertex, AbsenceModel, AbsenceId, UpdateAbsenceRequest> {

    @Override
    protected String getLabel() {
        return Label.Vertex.ABSENCE;
    }

    @Override
    protected Function<Vertex, AbsenceVertex> getVertexConverter() {
        return AbsenceVertex::new;
    }
}
