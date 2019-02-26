package de.consol.labs.aws.neptunedemoapp.common.facade;

import de.consol.labs.aws.neptunedemoapp.common.crud.Label;
import de.consol.labs.aws.neptunedemoapp.common.crud.absence.AbsenceCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.absence.params.AbsenceVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.certificate.CertificateCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.certificate.params.CertificateVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.certificationcenter.CertificationCenterCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.certificationcenter.params.CertificationCenterVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.customer.CustomerCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.customer.params.CustomerVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.degree.DegreeCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.degree.params.DegreeVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.edge.*;
import de.consol.labs.aws.neptunedemoapp.common.crud.edge.properties.Employee2CertificateEdgeProperties;
import de.consol.labs.aws.neptunedemoapp.common.crud.edge.properties.Employee2DegreeEdgeProperties;
import de.consol.labs.aws.neptunedemoapp.common.crud.edge.properties.Employee2ProjectEdgeProperties;
import de.consol.labs.aws.neptunedemoapp.common.crud.edge.properties.Employee2SkillEdgeProperties;
import de.consol.labs.aws.neptunedemoapp.common.crud.employee.EmployeeCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.employee.params.EmployeeVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.mapper.Mapper;
import de.consol.labs.aws.neptunedemoapp.common.crud.project.ProjectCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.project.params.ProjectVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.school.SchoolCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.school.params.SchoolVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.skill.SkillCrudController;
import de.consol.labs.aws.neptunedemoapp.common.crud.skill.params.SkillVertex;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Edge;

import java.util.Map;

public class GraphFacade {

    private final Mapper mapper = new Mapper();

    private final AbsenceCrudController absence = new AbsenceCrudController();
    private final CertificateCrudController certificate = new CertificateCrudController();
    private final CertificationCenterCrudController certificationCenter = new CertificationCenterCrudController();
    private final CustomerCrudController customerCrudController = new CustomerCrudController();
    private final DegreeCrudController degreeCrudController = new DegreeCrudController();
    private final EmployeeCrudController employeeCrudController = new EmployeeCrudController();
    private final ProjectCrudController projectCrudController = new ProjectCrudController();
    private final SchoolCrudController schoolCrudController = new SchoolCrudController();
    private final SkillCrudController skillCrudController = new SkillCrudController();

    public School2DegreeEdge linkSchool2Degree(final GraphTraversalSource g, final SchoolVertex src, final DegreeVertex dest) {
        final Edge edge = g.addE(Label.Edge.SCHOOL_2_DEGREE).from(src.getVertex()).to(dest.getVertex()).next();
        return new School2DegreeEdge(edge);
    }

    public Customer2ProjectEdge linkCustomer2Project(final GraphTraversalSource g, final CustomerVertex src, final ProjectVertex dest) {
        final Edge edge = g.addE(Label.Edge.CUSTOMER_2_PROJECT).from(src.getVertex()).to(dest.getVertex()).next();
        return new Customer2ProjectEdge(edge);
    }

    public CertificationCenter2CertificateEdge linkCertificationCenter2Certificate(final GraphTraversalSource g, final CertificationCenterVertex src, final CertificateVertex dest) {
        final Edge edge = g.addE(Label.Edge.CERTIFICATION_CENTER_2_CERTIFICATE).from(src.getVertex()).to(dest.getVertex()).next();
        return new CertificationCenter2CertificateEdge(edge);
    }

    public Employee2CertificateEdge linkEmployee2Certificate(final GraphTraversalSource g, final EmployeeVertex src, final CertificateVertex dest, final Employee2CertificateEdgeProperties properties) {
        final GraphTraversal<Edge, Edge> traversal = g.addE(Label.Edge.EMPLOYEE_2_CERTIFICATE).from(src.getVertex()).to(dest.getVertex());
        final Edge edge = setEdgeProperties(traversal, mapper.object2Properties(properties)).next();
        return new Employee2CertificateEdge(edge);
    }

    public Employee2DegreeEdge linkEmployee2Degree(final GraphTraversalSource g, final EmployeeVertex src, final DegreeVertex dest, final Employee2DegreeEdgeProperties properties) {
        final GraphTraversal<Edge, Edge> traversal = g.addE(Label.Edge.EMPLOYEE_2_DEGREE).from(src.getVertex()).to(dest.getVertex());
        final Edge edge = setEdgeProperties(traversal, mapper.object2Properties(properties)).next();
        return new Employee2DegreeEdge(edge);
    }

    public Employee2AbsenceEdge linkEmployee2Absence(final GraphTraversalSource g, final EmployeeVertex src, final AbsenceVertex dest) {
        final Edge edge = g.addE(Label.Edge.EMPLOYEE_2_ABSENCE).from(src.getVertex()).to(dest.getVertex()).next();
        return new Employee2AbsenceEdge(edge);
    }

    public Employee2ProjectEdge linkEmployee2Project(final GraphTraversalSource g, final EmployeeVertex src, final ProjectVertex dest, final Employee2ProjectEdgeProperties properties) {
        final GraphTraversal<Edge, Edge> traversal = g.addE(Label.Edge.EMPLOYEE_2_PROJECT).from(src.getVertex()).to(dest.getVertex());
        final Edge edge = setEdgeProperties(traversal, mapper.object2Properties(properties)).next();
        return new Employee2ProjectEdge(edge);
    }

    public Employee2SkillEdge linkEmployee2Skill(final GraphTraversalSource g, final EmployeeVertex src, final SkillVertex dest, final Employee2SkillEdgeProperties properties) {
        final GraphTraversal<Edge, Edge> traversal = g.addE(Label.Edge.EMPLOYEE_2_SKILL).from(src.getVertex()).to(dest.getVertex());
        final Edge edge = setEdgeProperties(traversal, mapper.object2Properties(properties)).next();
        return new Employee2SkillEdge(edge);
    }

    public AbsenceCrudController getAbsence() {
        return absence;
    }

    public CertificateCrudController getCertificate() {
        return certificate;
    }

    public CertificationCenterCrudController getCertificationCenter() {
        return certificationCenter;
    }

    public CustomerCrudController getCustomerCrudController() {
        return customerCrudController;
    }

    public DegreeCrudController getDegreeCrudController() {
        return degreeCrudController;
    }

    public EmployeeCrudController getEmployeeCrudController() {
        return employeeCrudController;
    }

    public ProjectCrudController getProjectCrudController() {
        return projectCrudController;
    }

    public SchoolCrudController getSchoolCrudController() {
        return schoolCrudController;
    }

    public SkillCrudController getSkillCrudController() {
        return skillCrudController;
    }

    private static GraphTraversal<Edge, Edge> setEdgeProperties(GraphTraversal<Edge, Edge> traversal, final Map<String, Object> properties) {
        for (final Map.Entry<String, Object> kv : properties.entrySet()) {
            traversal = traversal.property(kv.getKey(), kv.getValue());
        }
        return traversal;
    }
}
