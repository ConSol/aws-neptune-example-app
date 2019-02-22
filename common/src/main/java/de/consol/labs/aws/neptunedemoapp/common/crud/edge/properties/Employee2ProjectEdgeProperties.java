package de.consol.labs.aws.neptunedemoapp.common.crud.edge.properties;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class Employee2ProjectEdgeProperties {

    @Property
    private Long from;

    @Property
    private Long to;

    @Property
    private String as;

    public Long getFrom() {
        return from;
    }

    public Employee2ProjectEdgeProperties setFrom(final Long from) {
        this.from = from;
        return this;
    }

    public Long getTo() {
        return to;
    }

    public Employee2ProjectEdgeProperties setTo(final Long to) {
        this.to = to;
        return this;
    }

    public String getAs() {
        return as;
    }

    public Employee2ProjectEdgeProperties setAs(final String as) {
        this.as = as;
        return this;
    }
}
