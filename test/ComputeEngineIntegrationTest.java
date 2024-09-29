
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import api2.ComputationCoordinator;
import api2.ComputationCoordinatorEmpty;
import api2.ComputeEngine;
import api2.ComputeEngineEmpty;
import api2.DataStore;
import api2.OutputConfig;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ComputeEngineIntegrationTest {

    private ComputeEngineEmpty computeE;
    private ComputationCoordinatorEmpty computationCoordinator;
    private InMemoryDataStore dataStore;

    private InMemoryInput inputConfig;
    private InMemoryOutput outputConfig;

    private DataStore dataStorea;


    @BeforeEach
    public void setUp() {
 
        computeE = new ComputeEngineEmpty(inputConfig);
        computationCoordinator = new ComputationCoordinatorEmpty(dataStorea,computeE);//  back to datstore

        dataStore = new InMemoryDataStore();

        inputConfig = new InMemoryInput(Arrays.asList(1, 10, 25));
        outputConfig = new InMemoryOutput();
    }

    @Test
    public void testComputeEngineIntegration() {
    
        dataStore.processData(inputConfig, outputConfig);

        String[] expectedResults = {"1", "10", "25"};
        
        assertEquals(Arrays.asList(expectedResults), outputConfig.getOutputData());
    }
}
