package de.consol.labs.aws.neptunedemoapp.common.crud.project;

import de.consol.labs.aws.neptunedemoapp.common.crud.AbstractCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.Label;
import de.consol.labs.aws.neptunedemoapp.common.crud.project.params.ProjectId;
import de.consol.labs.aws.neptunedemoapp.common.crud.project.params.ProjectModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.project.params.ProjectVertex;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import java.util.function.Function;

public class ProjectCrudController extends AbstractCrudController<ProjectModel, ProjectVertex, ProjectModel, ProjectId, ProjectModel> {

    @Override
    protected String getLabel() {
        return Label.Vertex.PROJECT;
    }

    @Override
    protected Function<Vertex, ProjectVertex> getVertexConverter() {
        return ProjectVertex::new;
    }
}
