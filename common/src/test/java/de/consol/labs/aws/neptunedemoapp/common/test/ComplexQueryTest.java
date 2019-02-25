package de.consol.labs.aws.neptunedemoapp.common.test;


import de.consol.labs.aws.neptunedemoapp.common.crud.Label;
import org.apache.tinkerpop.gremlin.process.traversal.P;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversal;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__.*;

class ComplexQueryTest {

    private Graph graph;

    @BeforeEach
    void setUp() {
        graph = TinkerGraph.open();
        final TestDataSupplier testDataSupplier = new TestData1();
        testDataSupplier.fillGraph(graph.traversal());
    }

    @AfterEach
    void tearDown() throws Exception {
        graph.close();
    }

    @Test
    void testComplexQuery_bigBrotherCorporation_expectBob() {
        final String skill1 = "Java EE 8";
        final String skill2 = "PostgreSQL";
        final String skill3 = "TDD";
        final String certificate = "OCP Java SE 8";
        final String customer = "Big Brother Corporation";
        final long availableFrom = LocalDate.of(2018, Month.JANUARY, 21).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
        final long availableTo = LocalDate.of(2018, Month.JANUARY, 23).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
        final Consumer<List<Vertex>> checker = results -> {
            Assertions.assertEquals(1, results.size());
            final Vertex bob = results.get(0);
            Assertions.assertEquals("Bob", bob.property("firstName").value());
            Assertions.assertEquals("Smith", bob.property("lastName").value());
        };
        runComplexQuery(skill1, skill2, skill3, certificate, customer, availableFrom, availableTo, checker);
    }

    @Test
    void testComplexQuery_bigBrotherCorporation_expectEmpty() {
        final String skill1 = "Java EE 8";
        final String skill2 = "PostgreSQL";
        final String skill3 = "TDD";
        final String certificate = "OCP Java SE 8";
        final String customer = "Big Brother Corporation";
        final long availableFrom = LocalDate.of(2018, Month.MARCH, 21).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
        final long availableTo = LocalDate.of(2018, Month.MARCH, 23).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
        final Consumer<List<Vertex>> checker = results -> Assertions.assertTrue(results.isEmpty());
        runComplexQuery(skill1, skill2, skill3, certificate, customer, availableFrom, availableTo, checker);
    }

    @Test
    void testComplexQuery_spaceLogistics_expectBobAndAlice() {
        final String skill1 = "Java EE 8";
        final String skill2 = "PostgreSQL";
        final String skill3 = "TDD";
        final String certificate = "OCP Java SE 8";
        final String customer = "Space Logistics AG";
        final long availableFrom = LocalDate.of(2018, Month.JANUARY, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
        final long availableTo = LocalDate.of(2018, Month.FEBRUARY, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
        final Consumer<List<Vertex>> checker = results -> {
            Assertions.assertEquals(2, results.size());
            Assertions.assertEquals(new HashSet<>(Arrays.asList("Bob", "Alice")), getFirstNames(results));
        };
        runComplexQuery(skill1, skill2, skill3, certificate, customer, availableFrom, availableTo, checker);
    }

    @Test
    void testComplexQuery_spaceLogistics_expectOnlyBob() {
        final String skill1 = "Java EE 8";
        final String skill2 = "PostgreSQL";
        final String skill3 = "TDD";
        final String certificate = "OCP Java SE 8";
        final String customer = "Space Logistics AG";
        final long availableFrom = LocalDate.of(2018, Month.APRIL, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
        final long availableTo = LocalDate.of(2018, Month.APRIL, 11).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
        final Consumer<List<Vertex>> checker = results -> {
            Assertions.assertEquals(1, results.size());
            Assertions.assertEquals(Collections.singleton("Bob"), getFirstNames(results));
        };
        runComplexQuery(skill1, skill2, skill3, certificate, customer, availableFrom, availableTo, checker);
    }

    @Test
    void testComplexQuery_spaceLogistics_expectOnlyAlice() {
        final String skill1 = "Java EE 8";
        final String skill2 = "PostgreSQL";
        final String skill3 = "TDD";
        final String certificate = "OCP Java SE 8";
        final String customer = "Space Logistics AG";
        final long availableFrom = LocalDate.of(2018, Month.MARCH, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
        final long availableTo = LocalDate.of(2018, Month.MARCH, 21).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
        final Consumer<List<Vertex>> checker = results -> {
            Assertions.assertEquals(1, results.size());
            Assertions.assertEquals(Collections.singleton("Alice"), getFirstNames(results));
        };
        runComplexQuery(skill1, skill2, skill3, certificate, customer, availableFrom, availableTo, checker);
    }

    private void runComplexQuery(
            final String skill1,
            final String skill2,
            final String skill3,
            final String certificate,
            final String customer,
            final long availableFrom,
            final long availableTo,
            final Consumer<List<Vertex>> checker
    ) {
        final GraphTraversal<Vertex, Vertex> query = graph.traversal().V()
                .hasLabel(Label.Vertex.EMPLOYEE)
                .and(
                        out("has")
                                .hasLabel(Label.Vertex.SKILL)
                                .and(
                                        or(
                                                has("name", skill1),
                                                has("name", skill2),
                                                has("name", skill3)
                                        )
                                )
                                .count()
                                .is(P.gte(3))
                )
                .and(
                        out("has")
                                .hasLabel(Label.Vertex.CERTIFICATE)
                                .has("name", certificate)
                )
                .and(
                        out("workOn")
                                .in("order")
                                .hasLabel(Label.Vertex.CUSTOMER)
                                .has("name", customer)
                )
                .and(
                        not(
                                out("has")
                                        .hasLabel(Label.Vertex.ABSENCE)
                                        .and(
                                                or(
                                                        has("fromInclusive", P.between(availableFrom, availableTo)),
                                                        has("toInclusive", P.between(availableFrom, availableTo)),
                                                        and(
                                                                has("fromInclusive", P.lte(availableFrom)),
                                                                has("toInclusive", P.gte(availableTo))
                                                        )
                                                )
                                        )
                        )
                );
        final List<Vertex> results = query.toList();
        checker.accept(results);
    }

    private static Set<String> getFirstNames(final List<Vertex> vertices) {
        return vertices.stream()
                .map(v -> (String) v.property("firstName").value())
                .collect(Collectors.toSet());
    }
}
