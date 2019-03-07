package de.consol.labs.aws.neptunedemoapp.runadhocquery;

public class QueryParameters {

    private String skill1;
    private String skill2;
    private String skill3;
    private String certificate;
    private String customer;
    private Long availableFrom;
    private Long availableTo;

    public String getSkill1() {
        return skill1;
    }

    public QueryParameters setSkill1(final String skill1) {
        this.skill1 = skill1;
        return this;
    }

    public String getSkill2() {
        return skill2;
    }

    public QueryParameters setSkill2(final String skill2) {
        this.skill2 = skill2;
        return this;
    }

    public String getSkill3() {
        return skill3;
    }

    public QueryParameters setSkill3(final String skill3) {
        this.skill3 = skill3;
        return this;
    }

    public String getCertificate() {
        return certificate;
    }

    public QueryParameters setCertificate(final String certificate) {
        this.certificate = certificate;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public QueryParameters setCustomer(final String customer) {
        this.customer = customer;
        return this;
    }

    public Long getAvailableFrom() {
        return availableFrom;
    }

    public QueryParameters setAvailableFrom(final Long availableFrom) {
        this.availableFrom = availableFrom;
        return this;
    }

    public Long getAvailableTo() {
        return availableTo;
    }

    public QueryParameters setAvailableTo(final Long availableTo) {
        this.availableTo = availableTo;
        return this;
    }
}
