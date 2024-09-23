package api2.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ComputeEngineIntegrationTest {

    private ComputeEngine computeEngine;
    private ComputationCoordinator computationCoordinator;
    private InMemoryDataStore dataStore;

    private InMemoryInputConfig inputConfig;
    private InMemoryOutputConfig outputConfig;

    @Before
    public void setUp() {
 
        computeEngine = new ComputeEngineEmpty();
        computationCoordinator = new ComputationCoordinatorEmpty();

        dataStore = new InMemoryDataStore();

        inputConfig = new InMemoryInputConfig(Arrays.asList(1, 10, 25));
        outputConfig = new InMemoryOutputConfig();
    }

    @Test
    public void testComputeEngineIntegration() {
    
        dataStore.processData(inputConfig, outputConfig);

        String[] expectedResults = {"1", "10", "25"};
        
        assertEquals(Arrays.asList(expectedResults), outputConfig.getOutputData());
    }
}

