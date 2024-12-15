import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
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
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.nullable;
import api.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class ComputeEngineIntegrationTest {

    @Test
    public void testDataStore() {
        List<Integer> inputList = Arrays.asList(2, 10, 25);
        InMemoryInput input = new InMemoryInput(inputList);
        InMemoryOutput output = new InMemoryOutput("output1");
        DataStore dataStore = new InMemoryDataStore(input); 
        ComputeEngine engine = new ComputeEngineEmpty(null);
        ComputationCoordinator coordinator = new ComputationCoordinatorEmpty(dataStore, engine);
        ComputeRequest request = new ComputeRequest(input, output);
        ComputeResult result = coordinator.compute(request);
        System.out.println(dataStore.read(input));
        assertEquals(ComputeResult.SUCCESS, result);
        assertEquals("2results" + System.lineSeparator(), dataStore.read(input));
    }
    @Test
    public void testDataStoreRight() {
        List<Integer> inputList = Arrays.asList( 2, 3, 7);
        InMemoryInput input = new InMemoryInput(inputList);
        InMemoryOutput output = new InMemoryOutput("output1");
        DataStore dataStore = new InMemoryDataStore(input); 
        ComputeEngine engine = new ComputeEngineEmpty(null);
        ComputationCoordinator coordinator = new ComputationCoordinatorEmpty(dataStore, engine);
        ComputeRequest request = new ComputeRequest(input, output);
        ComputeResult result = coordinator.compute(request);
        System.out.println(dataStore.read(input));
        assertEquals(ComputeResult.SUCCESS, result);
        assertEquals("2, 3, 7results" + System.lineSeparator(), dataStore.read(input));
    }
     @Test
    public void testInputConfigNull() {
        InMemoryInput input = new InMemoryInput(null);
        InMemoryOutput output = new InMemoryOutput("output1");
         DataStore dataStore = new InMemoryDataStore(input); // Use TestDataStore
        ComputeEngine engine = new ComputeEngineEmpty(null); // Create ComputeEngineEmpty with no input
        ComputationCoordinator coordinator = new ComputationCoordinatorEmpty(dataStore, engine);
        ComputeRequest request = new ComputeRequest(input,output);
        ComputeResult result = coordinator.compute(request);
        assertEquals(ComputeResult.FAILURE, result);
    }
}