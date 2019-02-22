package de.consol.labs.aws.neptunedemoapp.common.crud.certificate.params;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class CertificateModel {

    @Property
    private String name;

    public String getName() {
        return name;
    }

    public CertificateModel setName(final String name) {
        this.name = name;
        return this;
    }
}
