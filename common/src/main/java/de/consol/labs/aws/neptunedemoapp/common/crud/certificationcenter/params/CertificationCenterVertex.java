package de.consol.labs.aws.neptunedemoapp.common.crud.certificationcenter.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractVertexAdapter;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public class CertificationCenterVertex extends AbstractVertexAdapter {
    public CertificationCenterVertex(final Vertex vertex) {
        super(vertex);
    }
}
