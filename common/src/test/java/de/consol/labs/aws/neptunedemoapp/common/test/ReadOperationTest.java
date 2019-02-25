package de.consol.labs.aws.neptunedemoapp.common.test;


import de.consol.labs.aws.neptunedemoapp.common.crud.employee.params.EmployeeId;
import de.consol.labs.aws.neptunedemoapp.common.crud.employee.params.EmployeeModel;
import de.consol.labs.aws.neptunedemoapp.common.facade.GraphFacade;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class ReadOperationTest {

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
    void testReadBob() {
        final GraphFacade gf = new GraphFacade();
        final Optional<EmployeeModel> model = gf.getEmployeeCrudController().read(graph.traversal(), new EmployeeId().setId(10L), EmployeeModel.class);
        Assertions.assertTrue(model.isPresent());
        final EmployeeModel bob = model.get();
        Assertions.assertEquals("Bob", bob.getFirstName());
        Assertions.assertEquals("Smith", bob.getLastName());
    }
}
