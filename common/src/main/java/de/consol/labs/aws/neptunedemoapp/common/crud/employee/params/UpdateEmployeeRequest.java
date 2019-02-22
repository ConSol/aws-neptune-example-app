package de.consol.labs.aws.neptunedemoapp.common.crud.employee.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class UpdateEmployeeRequest {

    @Property
    private String firstName;

    @Property
    private String lastName;

    @Property
    private String position;

    public String getFirstName() {
        return firstName;
    }

    public UpdateEmployeeRequest setFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UpdateEmployeeRequest setLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public UpdateEmployeeRequest setPosition(final String position) {
        this.position = position;
        return this;
    }
}
