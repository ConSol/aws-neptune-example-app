package de.consol.labs.aws.neptunedemoapp.common.crud.certificate;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.Label;
import de.consol.labs.aws.neptunedemoapp.common.crud.certificate.params.CertificateModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.certificate.params.CertificateVertex;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.function.Function;

public class CertificateCrudController extends AbstractCrudController<CertificateModel, CertificateVertex, CertificateModel, CertificateModel, CertificateModel> {

    @Override
    protected String getLabel() {
        return Label.Vertex.CERTIFICATE;
    }

    @Override
    protected Function<Vertex, CertificateVertex> getVertexConverter() {
        return CertificateVertex::new;
    }
}

