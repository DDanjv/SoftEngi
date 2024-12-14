import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import api.ComputationCoordinator;
import api.ComputationCoordinatorEmpty;
import api.ComputeEngine;
import api.ComputeEngineEmpty;
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
        compute = new ComputeEngineEmpty(inputConfig);
        dataStore = new InMemoryDataStore(inputConfig,outputConfig);
        computationCoordinator = new ComputationCoordinatorEmpty((DataStore) dataStore, compute);//  back to datstore
        inputConfig = new InMemoryInput(Arrays.asList(1, 10, 25));
        //outputConfig = new InMemoryOutput();
    }

    @Test
    public void testComputeEngineIntegration() {
        String[] expectedResults = {"1", "10", "25"};
        
        //assertEquals(Arrays.asList(expectedResults), outputConfig.getOutputData());
    }
}

