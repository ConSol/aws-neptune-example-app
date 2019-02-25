package de.consol.labs.aws.neptunedemoapp.common.test;

import de.consol.labs.aws.neptunedemoapp.common.crud.absence.params.AbsenceModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.absence.params.AbsenceVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.certificate.params.CertificateModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.certificate.params.CertificateVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.certificationcenter.params.CertificationCenterModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.certificationcenter.params.CertificationCenterVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.customer.params.CustomerModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.customer.params.CustomerVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.degree.params.DegreeModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.degree.params.DegreeVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.edge.properties.Employee2CertificateEdgeProperties;
import de.consol.labs.aws.neptunedemoapp.common.crud.edge.properties.Employee2DegreeEdgeProperties;
import de.consol.labs.aws.neptunedemoapp.common.crud.edge.properties.Employee2ProjectEdgeProperties;
import de.consol.labs.aws.neptunedemoapp.common.crud.edge.properties.Employee2SkillEdgeProperties;
import de.consol.labs.aws.neptunedemoapp.common.crud.employee.params.EmployeeModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.employee.params.EmployeeVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.project.params.ProjectModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.project.params.ProjectVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.school.params.SchoolModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.school.params.SchoolVertex;
import de.consol.labs.aws.neptunedemoapp.common.crud.skill.params.SkillModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.skill.params.SkillVertex;
import de.consol.labs.aws.neptunedemoapp.common.facade.GraphFacade;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneOffset;

public class TestData1 implements TestDataSupplier {

    private static final long PROJ_FOO_START = LocalDate.of(2017, Month.JANUARY, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
    private static final long PROJ_FOO_FINISH = LocalDate.of(2017, Month.APRIL, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
    private static final long PROJ_BAR_START = LocalDate.of(2017, Month.FEBRUARY, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
    private static final long PROJ_BAR_FINISH = LocalDate.of(2017, Month.MAY, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
    private static final long PROJ_BAZ_START = LocalDate.of(2017, Month.JUNE, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
    private static final long PROJ_BAZ_FINISH = LocalDate.of(2017, Month.SEPTEMBER, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
    private static final long PROJ_QUX_START = LocalDate.of(2017, Month.JANUARY, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
    private static final long PROJ_QUX_FINISH = LocalDate.of(2018, Month.JANUARY, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();

    @Override
    public void fillGraph(final GraphTraversalSource g) {
        final GraphFacade gf = new GraphFacade();
        final SchoolVertex rwth = gf.getSchoolCrudController().create(g, new SchoolModel().setName("RWTH"));
        final SchoolVertex tum = gf.getSchoolCrudController().create(g, new SchoolModel().setName("TUM"));
        final DegreeVertex rwthDegree = gf.getDegreeCrudController().create(g, new DegreeModel().setName("M.Sc. Software Systems Engineering"));
        final DegreeVertex tumDegree = gf.getDegreeCrudController().create(g, new DegreeModel().setName("B.Sc. Computer Science"));
        gf.linkSchool2Degree(g, tum, tumDegree);
        gf.linkSchool2Degree(g, rwth, rwthDegree);
        final CertificationCenterVertex certCenterOracle = gf.getCertificationCenter().create(g, new CertificationCenterModel().setName("Oracle"));
        final CertificationCenterVertex certCenterAws = gf.getCertificationCenter().create(g, new CertificationCenterModel().setName("AWS"));
        final CertificateVertex certOcpJavaSe8 = gf.getCertificate().create(g, new CertificateModel().setName("OCP Java SE 8"));
        final CertificateVertex certAwsCsaa = gf.getCertificate().create(g, new CertificateModel().setName("AWS Certified Solutions Architect -- Associate"));
        gf.linkCertificationCenter2Certificate(g, certCenterOracle, certOcpJavaSe8);
        gf.linkCertificationCenter2Certificate(g, certCenterAws, certAwsCsaa);
        final CustomerVertex custBigBro = gf.getCustomerCrudController().create(g, new CustomerModel().setName("Big Brother Corporation"));
        final CustomerVertex custSpaceLogistics = gf.getCustomerCrudController().create(g, new CustomerModel().setName("Space Logistics AG"));
        final CustomerVertex custFixieWixie = gf.getCustomerCrudController().create(g, new CustomerModel().setName("Fixie-Wixie GmbH"));
        final ProjectVertex projFoo = gf.getProjectCrudController().create(g, new ProjectModel().setName("Foo").setStartedAt(PROJ_FOO_START).setFinishedAt(PROJ_FOO_FINISH));
        final ProjectVertex projBar = gf.getProjectCrudController().create(g, new ProjectModel().setName("Bar").setStartedAt(PROJ_BAR_START).setFinishedAt(PROJ_BAR_FINISH));
        final ProjectVertex projBaz = gf.getProjectCrudController().create(g, new ProjectModel().setName("Baz").setStartedAt(PROJ_BAZ_START).setFinishedAt(PROJ_BAZ_FINISH));
        final ProjectVertex projQux = gf.getProjectCrudController().create(g, new ProjectModel().setName("Qux").setStartedAt(PROJ_QUX_START).setFinishedAt(PROJ_QUX_FINISH));
        gf.linkCustomer2Project(g, custBigBro, projFoo);
        gf.linkCustomer2Project(g, custBigBro, projBar);
        gf.linkCustomer2Project(g, custSpaceLogistics, projBaz);
        gf.linkCustomer2Project(g, custFixieWixie, projQux);
        final SkillVertex skillJavaSe8 = gf.getSkillCrudController().create(g, new SkillModel().setName("Java SE 8"));
        final SkillVertex skillJavaEe8 = gf.getSkillCrudController().create(g, new SkillModel().setName("Java EE 8"));
        final SkillVertex skillPostgreSql = gf.getSkillCrudController().create(g, new SkillModel().setName("PostgreSQL"));
        final SkillVertex skillExcel = gf.getSkillCrudController().create(g, new SkillModel().setName("Excel"));
        final SkillVertex skillCitrus = gf.getSkillCrudController().create(g, new SkillModel().setName("Citrus"));
        final SkillVertex skillTdd = gf.getSkillCrudController().create(g, new SkillModel().setName("TDD"));
        final SkillVertex skillBdd = gf.getSkillCrudController().create(g, new SkillModel().setName("BDD"));
        final EmployeeVertex bob = gf.getEmployeeCrudController().create(
                g,
                new EmployeeModel().setId(10L).setFirstName("Bob").setLastName("Smith").setPosition("software engineer")
        );
        final EmployeeVertex alice = gf.getEmployeeCrudController().create(
                g,
                new EmployeeModel().setId(20L).setFirstName("Alice").setLastName("Brown").setPosition("senior software engineer")
        );
        final EmployeeVertex garry = gf.getEmployeeCrudController().create(
                g,
                new EmployeeModel().setId(30L).setFirstName("Garry").setLastName("Osborne").setPosition("project manager")
        );
        final EmployeeVertex melissa = gf.getEmployeeCrudController().create(
                g,
                new EmployeeModel().setId(40L).setFirstName("Melissa").setLastName("May").setPosition("test engineer")
        );
        gf.linkEmployee2Degree(
                g,
                bob,
                rwthDegree,
                new Employee2DegreeEdgeProperties().setEarnedAt(LocalDate.of(2015, Month.MARCH, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
        );
        gf.linkEmployee2Degree(
                g,
                alice,
                rwthDegree,
                new Employee2DegreeEdgeProperties().setEarnedAt(LocalDate.of(2013, Month.MARCH, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
        );
        gf.linkEmployee2Degree(
                g,
                garry,
                tumDegree,
                new Employee2DegreeEdgeProperties().setEarnedAt(LocalDate.of(2016, Month.MARCH, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
        );
        gf.linkEmployee2Degree(
                g,
                melissa,
                tumDegree,
                new Employee2DegreeEdgeProperties().setEarnedAt(LocalDate.of(2016, Month.AUGUST, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
        );
        gf.linkEmployee2Certificate(
                g,
                bob,
                certOcpJavaSe8,
                new Employee2CertificateEdgeProperties()
                        .setEarnedAt(LocalDate.of(2016, Month.DECEMBER, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
                        .setValidUntil(LocalDate.of(2018, Month.DECEMBER, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
        );
        gf.linkEmployee2Certificate(
                g,
                alice,
                certOcpJavaSe8,
                new Employee2CertificateEdgeProperties()
                        .setEarnedAt(LocalDate.of(2016, Month.DECEMBER, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
                        .setValidUntil(LocalDate.of(2018, Month.DECEMBER, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
        );
        gf.linkEmployee2Certificate(
                g,
                alice,
                certAwsCsaa,
                new Employee2CertificateEdgeProperties()
                        .setEarnedAt(LocalDate.of(2016, Month.NOVEMBER, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
                        .setValidUntil(LocalDate.of(2018, Month.NOVEMBER, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
        );
        // bob's skills
        gf.linkEmployee2Skill(g, bob, skillJavaSe8, new Employee2SkillEdgeProperties().setLevel(70));
        gf.linkEmployee2Skill(g, bob, skillJavaEe8, new Employee2SkillEdgeProperties().setLevel(80));
        gf.linkEmployee2Skill(g, bob, skillPostgreSql, new Employee2SkillEdgeProperties().setLevel(65));
        gf.linkEmployee2Skill(g, bob, skillTdd, new Employee2SkillEdgeProperties().setLevel(80));
        gf.linkEmployee2Skill(g, bob, skillCitrus, new Employee2SkillEdgeProperties().setLevel(85));
        // alice's skills
        gf.linkEmployee2Skill(g, alice, skillJavaSe8, new Employee2SkillEdgeProperties().setLevel(90));
        gf.linkEmployee2Skill(g, alice, skillJavaEe8, new Employee2SkillEdgeProperties().setLevel(95));
        gf.linkEmployee2Skill(g, alice, skillPostgreSql, new Employee2SkillEdgeProperties().setLevel(90));
        gf.linkEmployee2Skill(g, alice, skillCitrus, new Employee2SkillEdgeProperties().setLevel(100));
        gf.linkEmployee2Skill(g, alice, skillTdd, new Employee2SkillEdgeProperties().setLevel(95));
        gf.linkEmployee2Skill(g, alice, skillBdd, new Employee2SkillEdgeProperties().setLevel(90));
        gf.linkEmployee2Skill(g, alice, skillExcel, new Employee2SkillEdgeProperties().setLevel(30));
        // garry's skills
        gf.linkEmployee2Skill(g, garry, skillExcel, new Employee2SkillEdgeProperties().setLevel(100));
        // melissa's skills
        gf.linkEmployee2Skill(g, melissa, skillJavaSe8, new Employee2SkillEdgeProperties().setLevel(75));
        gf.linkEmployee2Skill(g, melissa, skillPostgreSql, new Employee2SkillEdgeProperties().setLevel(80));
        gf.linkEmployee2Skill(g, melissa, skillCitrus, new Employee2SkillEdgeProperties().setLevel(100));
        gf.linkEmployee2Skill(g, melissa, skillTdd, new Employee2SkillEdgeProperties().setLevel(100));
        gf.linkEmployee2Skill(g, melissa, skillBdd, new Employee2SkillEdgeProperties().setLevel(100));
        // bob worked on projects: foo, baz
        gf.linkEmployee2Project(
                g,
                bob,
                projFoo,
                new Employee2ProjectEdgeProperties()
                        .setFrom(PROJ_FOO_START)
                        .setTo(PROJ_FOO_FINISH)
                        .setAs("developer")
        );
        gf.linkEmployee2Project(
                g,
                bob,
                projBaz,
                new Employee2ProjectEdgeProperties()
                        .setFrom(PROJ_BAZ_START)
                        .setTo(PROJ_BAZ_FINISH)
                        .setAs("developer")
        );
        // alice worked on projects: baz
        gf.linkEmployee2Project(
                g,
                alice,
                projBaz,
                new Employee2ProjectEdgeProperties()
                        .setFrom(PROJ_BAZ_START)
                        .setTo(PROJ_BAZ_FINISH)
                        .setAs("developer")
        );
        // garry worked on projects: foo, bar, baz
        gf.linkEmployee2Project(
                g,
                garry,
                projFoo,
                new Employee2ProjectEdgeProperties()
                        .setFrom(PROJ_FOO_START)
                        .setTo(PROJ_FOO_FINISH)
                        .setAs("project manager")
        );
        gf.linkEmployee2Project(
                g,
                garry,
                projBar,
                new Employee2ProjectEdgeProperties()
                        .setFrom(PROJ_BAR_START)
                        .setTo(PROJ_BAR_FINISH)
                        .setAs("project manager")
        );
        gf.linkEmployee2Project(
                g,
                garry,
                projBaz,
                new Employee2ProjectEdgeProperties()
                        .setFrom(PROJ_BAZ_START)
                        .setTo(PROJ_BAZ_FINISH)
                        .setAs("project manager")
        );
        // melissa worked on projects: qux
        gf.linkEmployee2Project(
                g,
                melissa,
                projQux,
                new Employee2ProjectEdgeProperties()
                        .setFrom(PROJ_QUX_START)
                        .setTo(PROJ_QUX_FINISH)
                        .setAs("test engineer")
        );
        // bob's vacations (previous and planned)
        final AbsenceVertex bobVacation1 = gf.getAbsence().create(
                g,
                new AbsenceModel()
                        .setId(10L)
                        .setType("vacation")
                        .setFromInclusive(LocalDate.of(2017, Month.JANUARY, 20).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
                        .setToInclusive(LocalDate.of(2017, Month.JANUARY, 25).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
        );
        gf.linkEmployee2Absence(g, bob, bobVacation1);
        final AbsenceVertex bobVacation2 = gf.getAbsence().create(
                g,
                new AbsenceModel()
                        .setId(20L)
                        .setType("vacation")
                        .setFromInclusive(LocalDate.of(2017, Month.FEBRUARY, 20).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
                        .setToInclusive(LocalDate.of(2017, Month.FEBRUARY, 25).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
        );
        gf.linkEmployee2Absence(g, bob, bobVacation2);
        final AbsenceVertex bobVacation3 = gf.getAbsence().create(
                g,
                new AbsenceModel()
                        .setId(30L)
                        .setType("vacation")
                        .setFromInclusive(LocalDate.of(2018, Month.MARCH, 20).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
                        .setToInclusive(LocalDate.of(2018, Month.MARCH, 25).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
        );
        gf.linkEmployee2Absence(g, bob, bobVacation3);
        // alice's vacations (previous and planned)
        final AbsenceVertex aliceVacation1 = gf.getAbsence().create(
                g,
                new AbsenceModel()
                        .setId(100L)
                        .setType("vacation")
                        .setFromInclusive(LocalDate.of(2018, Month.MARCH, 30).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
                        .setToInclusive(LocalDate.of(2018, Month.APRIL, 30).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
        );
        gf.linkEmployee2Absence(g, alice, aliceVacation1);
        // melissa's vacations (previous and planned)
        final AbsenceVertex melissaVacation1 = gf.getAbsence().create(
                g,
                new AbsenceModel()
                        .setId(100L)
                        .setType("vacation")
                        .setFromInclusive(LocalDate.of(2018, Month.MAY, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
                        .setToInclusive(LocalDate.of(2018, Month.MAY, 20).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli())
        );
        gf.linkEmployee2Absence(g, melissa, melissaVacation1);
    }
}
