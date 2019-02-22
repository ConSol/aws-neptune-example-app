package de.consol.labs.aws.neptunedemoapp.common.crud.skill;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.Label;
import de.consol.labs.aws.neptunedemoapp.common.crud.skill.params.SkillModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.skill.params.SkillVertex;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.function.Function;

public class SkillCrudController extends AbstractCrudController<SkillModel, SkillVertex, SkillModel, SkillModel, SkillModel> {

    @Override
    protected String getLabel() {
        return Label.Vertex.SKILL;
    }

    @Override
    protected Function<Vertex, SkillVertex> getVertexConverter() {
        return SkillVertex::new;
    }
}

