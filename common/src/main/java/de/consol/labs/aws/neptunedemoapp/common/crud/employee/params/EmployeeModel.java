package de.consol.labs.aws.neptunedemoapp.common.crud.employee.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class EmployeeModel {

    @Property
    private Long id;

    @Property
    private String firstName;

    @Property
    private String lastName;

    @Property
    private String position;

    public Long getId() {
        return id;
    }

    public EmployeeModel setId(final Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeModel setFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeModel setLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public EmployeeModel setPosition(final String position) {
        this.position = position;
        return this;
    }
}
