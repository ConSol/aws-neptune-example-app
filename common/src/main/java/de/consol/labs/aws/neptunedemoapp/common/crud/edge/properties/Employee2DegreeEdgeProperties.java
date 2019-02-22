package de.consol.labs.aws.neptunedemoapp.common.crud.edge.properties;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class Employee2DegreeEdgeProperties {

    @Property
    private Long earnedAt;

    public Long getEarnedAt() {
        return earnedAt;
    }

    public Employee2DegreeEdgeProperties setEarnedAt(final Long earnedAt) {
        this.earnedAt = earnedAt;
        return this;
    }
}
