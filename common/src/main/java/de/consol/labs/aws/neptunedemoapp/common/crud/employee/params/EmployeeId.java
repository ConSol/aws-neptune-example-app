package de.consol.labs.aws.neptunedemoapp.common.crud.employee.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class EmployeeId {

    @Property
    private Long id;

    public Long getId() {
        return id;
    }

    public EmployeeId setId(final Long id) {
        this.id = id;
        return this;
    }
}
