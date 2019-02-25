package de.consol.labs.aws.neptunedemoapp.reademployee;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import de.consol.labs.aws.neptunedemoapp.common.crud.employee.params.EmployeeId;
import de.consol.labs.aws.neptunedemoapp.common.crud.employee.params.EmployeeModel;
import de.consol.labs.aws.neptunedemoapp.common.facade.GraphFacade;
import de.consol.labs.aws.neptunedemoapp.common.remote.RemoteClusterAdapter;
import de.consol.labs.aws.neptunedemoapp.common.remote.RemoteConnectionSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;

import java.util.Optional;

public class ReadEmployeeHandler implements RequestHandler<EmployeeId, EmployeeModel> {

    private static final Logger LOG = LogManager.getLogger(ReadEmployeeHandler.class);

    @Override
    public EmployeeModel handleRequest(final EmployeeId employeeId, final Context context) {
        final RemoteConnectionSettings settings = new RemoteConnectionSettings()
                .setEndpoint(System.getenv(EnvironmentVariable.NEPTUNE_ENDPOINT))
                .setPort(Integer.parseInt(System.getenv(EnvironmentVariable.NEPTUNE_PORT)))
                .setEnableSsl(true)
                .setKeyCertChainFile(getClass().getClassLoader().getResource("SFSRootCAG2.pem").getFile());
        try (final RemoteClusterAdapter adapter = new RemoteClusterAdapter(settings)) {
            try (final GraphTraversalSource g = adapter.getGraphTraversalSource()) {
                final GraphFacade gf = new GraphFacade();
                final Optional<EmployeeModel> employee = gf.getEmployeeCrudController().read(g, employeeId, EmployeeModel.class);
                if (!employee.isPresent()) {
                    LOG.info("could not find employee with ID {}", employeeId.getId());
                    return null;
                }
                final EmployeeModel result = employee.get();
                LOG.info("employee: {}", result);
                return result;
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
