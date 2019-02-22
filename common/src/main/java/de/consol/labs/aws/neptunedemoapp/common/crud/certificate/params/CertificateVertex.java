package de.consol.labs.aws.neptunedemoapp.common.crud.certificate.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractVertexAdapter;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public class CertificateVertex extends AbstractVertexAdapter {
    public CertificateVertex(final Vertex vertex) {
        super(vertex);
    }
}
