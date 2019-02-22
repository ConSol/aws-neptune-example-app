package de.consol.labs.aws.neptunedemoapp.common.crud.absence.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class AbsenceModel {

    @Property
    private Long id;

    @Property
    private String type;

    @Property
    private Long fromInclusive;

    @Property
    private Long toInclusive;

    public Long getId() {
        return id;
    }

    public AbsenceModel setId(final Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public AbsenceModel setType(final String type) {
        this.type = type;
        return this;
    }

    public Long getFromInclusive() {
        return fromInclusive;
    }

    public AbsenceModel setFromInclusive(final Long fromInclusive) {
        this.fromInclusive = fromInclusive;
        return this;
    }

    public Long getToInclusive() {
        return toInclusive;
    }

    public AbsenceModel setToInclusive(final Long toInclusive) {
        this.toInclusive = toInclusive;
        return this;
    }
}
