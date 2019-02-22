package de.consol.labs.aws.neptunedemoapp.common.crud.skill.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class SkillModel {

    @Property
    private String name;

    public String getName() {
        return name;
    }

    public SkillModel setName(final String name) {
        this.name = name;
        return this;
    }
}
