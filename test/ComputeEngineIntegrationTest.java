import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import api.ComputationCoordinator;
import api.ComputationCoordinatorEmpty;
import api.ComputeEngine;
import api.ComputeEngineEmpty;
import api.ComputeRequest;
import api.ComputeResult;
import api.DataStore;
import api.OutputConfig;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class ComputeEngineIntegrationTest {

    private ComputeEngineEmpty compute;
    private ComputationCoordinatorEmpty computationCoordinator;
    private InMemoryDataStore dataStore;

    private InMemoryInput inputConfig;
    private InMemoryOutput outputConfig;

    @BeforeEach
    public void setUp() {

        inputConfig = new InMemoryInput(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,25));
        outputConfig = new InMemoryOutput("");
        compute = new ComputeEngineEmpty(inputConfig);
        dataStore = new InMemoryDataStore(inputConfig, outputConfig);
        computationCoordinator = new ComputationCoordinatorEmpty((DataStore) dataStore, compute);
    }

    @Test
    public void testComputeEngineIntegration() {
        /*// Simulate computation
        ComputeRequest request = new ComputeRequest(inputConfig, outputConfig);
        ComputeResult result = computationCoordinator.compute(request);

        String actResults = dataStore.read();
        System.out.println(actResults);
        String[] expectedResults = {"1", "10", "25"};*/
    }
}