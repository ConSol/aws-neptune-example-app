package de.consol.labs.aws.neptunedemoapp.common.crud.degree.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class DegreeModel {

    @Property
    private String name;

    public String getName() {
        return name;
    }

    public DegreeModel setName(final String name) {
        this.name = name;
        return this;
    }
}
