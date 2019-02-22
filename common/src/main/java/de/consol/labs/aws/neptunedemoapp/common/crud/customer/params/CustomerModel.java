package de.consol.labs.aws.neptunedemoapp.common.crud.customer.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class CustomerModel {

    @Property
    private String name;

    public String getName() {
        return name;
    }

    public CustomerModel setName(final String name) {
        this.name = name;
        return this;
    }
}
