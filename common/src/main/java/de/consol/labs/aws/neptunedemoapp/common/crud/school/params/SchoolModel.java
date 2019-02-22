package de.consol.labs.aws.neptunedemoapp.common.crud.school.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class SchoolModel {

    @Property
    private String name;

    public String getName() {
        return name;
    }

    public SchoolModel setName(final String name) {
        this.name = name;
        return this;
    }
}
