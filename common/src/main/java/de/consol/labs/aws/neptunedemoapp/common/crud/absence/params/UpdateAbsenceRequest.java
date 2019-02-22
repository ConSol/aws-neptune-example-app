package de.consol.labs.aws.neptunedemoapp.common.crud.absence.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class UpdateAbsenceRequest {

    @Property
    private String type;

    @Property
    private Long fromInclusive;

    @Property
    private Long toInclusive;

    public String getType() {
        return type;
    }

    public UpdateAbsenceRequest setType(final String type) {
        this.type = type;
        return this;
    }

    public Long getFromInclusive() {
        return fromInclusive;
    }

    public UpdateAbsenceRequest setFromInclusive(final Long fromInclusive) {
        this.fromInclusive = fromInclusive;
        return this;
    }

    public Long getToInclusive() {
        return toInclusive;
    }

    public UpdateAbsenceRequest setToInclusive(final Long toInclusive) {
        this.toInclusive = toInclusive;
        return this;
    }
}
