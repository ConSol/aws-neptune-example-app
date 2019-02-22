package de.consol.labs.aws.neptunedemoapp.common.crud.edge.properties;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class Employee2SkillEdgeProperties {

    @Property
    private Integer level;

    public Integer getLevel() {
        return level;
    }

    public Employee2SkillEdgeProperties setLevel(final Integer level) {
        this.level = level;
        return this;
    }
}
