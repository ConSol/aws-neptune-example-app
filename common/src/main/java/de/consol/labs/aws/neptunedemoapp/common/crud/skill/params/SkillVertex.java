package de.consol.labs.aws.neptunedemoapp.common.crud.skill.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractVertexAdapter;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public class SkillVertex extends AbstractVertexAdapter {
    public SkillVertex(final Vertex vertex) {
        super(vertex);
    }
}
