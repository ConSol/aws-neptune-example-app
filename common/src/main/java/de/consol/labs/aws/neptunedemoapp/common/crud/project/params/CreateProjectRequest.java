package de.consol.labs.aws.neptunedemoapp.common.crud.project.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class CreateProjectRequest {

    @Property
    private String name;

    public String getName() {
        return name;
    }

    public CreateProjectRequest setName(final String name) {
        this.name = name;
        return this;
    }
}
