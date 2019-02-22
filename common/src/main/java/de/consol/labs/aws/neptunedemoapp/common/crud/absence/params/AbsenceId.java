package de.consol.labs.aws.neptunedemoapp.common.crud.absence.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class AbsenceId {

    @Property
    private Long id;

    public Long getId() {
        return id;
    }

    public AbsenceId setId(final Long id) {
        this.id = id;
        return this;
    }
}
