
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import api2.ComputationCoordinator;
import api2.ComputationCoordinatorEmpty;
import api2.ComputeEngine;
import api2.ComputeEngineEmpty;
import api2.ComputeRequest;
import api2.ComputeResult;
import api2.DataStore;
import api2.OutputConfig;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ComputeEngineIntegrationTest {

    private ComputeEnginePrototypeSmoke computeE;
    private ComputationCoordinatorPrototypeSmoke computationCoordinator;
    private InMemoryDataStore dataStore;

    private InMemoryInput inputConfig;
    private InMemoryOutput outputConfig;
    private ComputeRequest hold; 
    private ComputeResult fin ;



    @BeforeEach
    public void setUp() {
 
        computeE = new ComputeEnginePrototypeSmoke(); //todo clean it up 

        dataStore = new InMemoryDataStore(inputConfig,outputConfig);

        computationCoordinator = new ComputationCoordinatorPrototypeSmoke();//  back to datstore


        inputConfig = new InMemoryInput(Arrays.asList(2, 3 , 4, 5 , 6, 7, 8, 9, 10, 11, 12));
        outputConfig = new InMemoryOutput();
    }

    @Test
    public void testComputeEngineIntegration() {
    
        computationCoordinator.testPrototype();
        String[] expectedResults = {"1", "10", "25"};
        
        assertEquals(Arrays.asList(expectedResults), outputConfig.getOutputData());
    }
}

