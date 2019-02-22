package de.consol.labs.aws.neptunedemoapp.common.crud;

public final class Label {

    public static final class Vertex {
        public static final String SCHOOL = "School";
        public static final String ABSENCE = "Absence";
        public static final String CUSTOMER = "Customer";
        public static final String DEGREE = "Degree";
        public static final String EMPLOYEE = "Employee";
        public static final String PROJECT = "Project";
        public static final String CERTIFICATE = "Certificate";
        public static final String CERTIFICATION_CENTER = "CertificationCenter";
        public static final String SKILL = "Skill";

        private Vertex() {
        }
    }

    public static final class Edge {
        public static final String SCHOOL_2_DEGREE = "teach";

        public static final String CUSTOMER_2_PROJECT = "order";

        public static final String EMPLOYEE_2_DEGREE = "has";
        public static final String EMPLOYEE_2_CERTIFICATE = "has";
        public static final String EMPLOYEE_2_SKILL = "has";
        public static final String EMPLOYEE_2_ABSENCE = "has";
        public static final String EMPLOYEE_2_PROJECT = "workOn";

        public static final String CERTIFICATION_CENTER_2_CERTIFICATE = "train";

        private Edge() {
        }
    }

    private Label() {
    }
}
