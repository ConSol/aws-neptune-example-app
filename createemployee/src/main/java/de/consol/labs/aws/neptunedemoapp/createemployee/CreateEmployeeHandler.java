package de.consol.labs.aws.neptunedemoapp.createemployee;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import de.consol.labs.aws.neptunedemoapp.common.crud.employee.params.EmployeeModel;
import de.consol.labs.aws.neptunedemoapp.common.crud.employee.params.EmployeeVertex;
import de.consol.labs.aws.neptunedemoapp.common.facade.GraphFacade;
import de.consol.labs.aws.neptunedemoapp.common.remote.RemoteClusterAdapter;
import de.consol.labs.aws.neptunedemoapp.common.remote.RemoteConnectionSettings;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;

public class CreateEmployeeHandler implements RequestHandler<EmployeeModel, Object> {

    @Override
    public Object handleRequest(final EmployeeModel employeeModel, final Context context) {
        final RemoteConnectionSettings settings = new RemoteConnectionSettings()
                .setEndpoint(System.getenv(EnvironmentVariable.NEPTUNE_ENDPOINT))
                .setPort(Integer.parseInt(System.getenv(EnvironmentVariable.NEPTUNE_PORT)))
                .setEnableSsl(true)
                .setKeyCertChainFile(getClass().getClassLoader().getResource("SFSRootCAG2.pem").getFile());
        try (final RemoteClusterAdapter adapter = new RemoteClusterAdapter(settings)) {
            try (final GraphTraversalSource g = adapter.getGraphTraversalSource()) {
                final GraphFacade gf = new GraphFacade();
                final EmployeeVertex v = gf.getEmployeeCrudController().create(g, employeeModel);
                return v.id();
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
