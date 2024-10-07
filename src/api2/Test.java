package api2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import api2.ComputationCoordinatorEmpty;
import api2.DataStore;
import api2.ComputeEngine;
import api2.DataStoreEmpty;
import api2.input;
import api2.InputConfig;
import api2.ComputeEngineEmpty;
import api2.ComputeResult;
import api2.ComputeRequest;

public class Test {

    @Test
    public void testComputeWithEmptyInputList() {
        // Arrange
        InputConfig emptyInputConfig = new input(Collections.emptyList());
        ComputeRequest request = new ComputeRequest(emptyInputConfig, null);


        ComputeResult result = coordinator.compute(request);

        // Assert
        assertEquals(ComputeResult.FAILURE, result); // Expecting failure when input list is empty
    }
}
