
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



    @BeforeEach
    public void setUp() {
 
        //computeE = new ComputeEngineEmpty(inputConfig); TODO
        computationCoordinator = new ComputationCoordinatorEmpty(dataStore,computeE);//  back to datstore

        dataStore = new InMemoryDataStore(inputConfig,outputConfig);

        inputConfig = new InMemoryInput(Arrays.asList(1, 10, 25));
        outputConfig = new InMemoryOutput();
    }

    @Test
    public void testComputeEngineIntegration() {
    
        dataStore.process();

        String[] expectedResults = {"1", "10", "25"};
        
        assertEquals(Arrays.asList(expectedResults), outputConfig.getOutputData());
    }
}

