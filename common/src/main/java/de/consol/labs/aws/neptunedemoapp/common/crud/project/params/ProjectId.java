package de.consol.labs.aws.neptunedemoapp.common.crud.project.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class ProjectId {

    @Property
    private String name;

    public String getName() {
        return name;
    }

    public ProjectId setName(final String name) {
        this.name = name;
        return this;
    }
}
