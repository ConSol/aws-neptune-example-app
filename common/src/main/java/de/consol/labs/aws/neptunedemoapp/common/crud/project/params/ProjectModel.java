package de.consol.labs.aws.neptunedemoapp.common.crud.project.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class ProjectModel {

    @Property
    private String name;

    @Property
    private Long startedAt;

    @Property
    private Long finishedAt;

    public String getName() {
        return name;
    }

    public ProjectModel setName(final String name) {
        this.name = name;
        return this;
    }

    public Long getStartedAt() {
        return startedAt;
    }

    public ProjectModel setStartedAt(final Long startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    public Long getFinishedAt() {
        return finishedAt;
    }

    public ProjectModel setFinishedAt(final Long finishedAt) {
        this.finishedAt = finishedAt;
        return this;
    }
}
