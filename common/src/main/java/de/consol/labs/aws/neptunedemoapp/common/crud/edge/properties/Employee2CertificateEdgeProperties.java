package de.consol.labs.aws.neptunedemoapp.common.crud.edge.properties;

import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Property;

public class Employee2CertificateEdgeProperties {

    @Property
    private Long earnedAt;

    @Property
    private Long validUntil;

    public Long getEarnedAt() {
        return earnedAt;
    }

    public Employee2CertificateEdgeProperties setEarnedAt(final Long earnedAt) {
        this.earnedAt = earnedAt;
        return this;
    }

    public Long getValidUntil() {
        return validUntil;
    }

    public Employee2CertificateEdgeProperties setValidUntil(final Long validUntil) {
        this.validUntil = validUntil;
        return this;
    }
}
