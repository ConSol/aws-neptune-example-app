package de.consol.labs.aws.neptunedemoapp.common.crud.certificationcenter;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.Label;
import de.consol.labs.aws.neptunedemoapp.common.crud.certificationcenter.params.CertificationCenterModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.certificationcenter.params.CertificationCenterVertex;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.function.Function;

public class CertificationCenterCrudController extends AbstractCrudController<CertificationCenterModel, CertificationCenterVertex, CertificationCenterModel, CertificationCenterModel, CertificationCenterModel> {

    @Override
    protected String getLabel() {
        return Label.Vertex.CERTIFICATION_CENTER;
    }

    @Override
    protected Function<Vertex, CertificationCenterVertex> getVertexConverter() {
        return CertificationCenterVertex::new;
    }
}

