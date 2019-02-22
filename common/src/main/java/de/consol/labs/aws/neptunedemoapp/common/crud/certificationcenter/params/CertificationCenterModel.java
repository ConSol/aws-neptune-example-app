package de.consol.labs.aws.neptunedemoapp.common.crud.certificationcenter.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class CertificationCenterModel {

    @Property
    private String name;

    public String getName() {
        return name;
    }

    public CertificationCenterModel setName(final String name) {
        this.name = name;
        return this;
    }
}
