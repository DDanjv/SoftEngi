// Imports from api2 package
import api2.ComputationCoordinatorEmpty;
import api2.ComputeEngine;
import api2.ComputeRequest;
import api2.ComputeResult;
import api2.DataStore;
import api2.DataStoreFile;
import api2.InputConfig;
import api2.OutputConfig;
import api2.input;
import api2.output;


import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class ComputationCoordinatorEmptyTest {

    @InjectMocks
    private ComputationCoordinatorEmpty coordinator;

    
    @Mock
    private DataStore mockDataStore;

    @Mock
    private ComputeEngine mockComputeEngine;

    @Mock
    private InputConfig mockInputConfig;

    @Mock
    private OutputConfig mockOutputConfig;

    private ComputeRequest mockRequest;


    @Before
    public void setUp() {
       
        MockitoAnnotations.openMocks(this);
        coordinator = new ComputationCoordinatorEmpty(mockDataStore, mockComputeEngine);

        mockRequest = new ComputeRequest(mockInputConfig, mockOutputConfig);
    }

    @Test
    public void testComputeWithEmptyInput() {
        // Set up the mock behavior for empty input list
        when(mockInputConfig.getInputList()).thenReturn(List.of());  // Empty list

        // Simulate the ComputeEngine returning an empty list when passed an empty input
        when(mockComputeEngine.compute(List.of())).thenReturn(List.of());

        // Perform the computation with the mock request
        ComputeResult result = coordinator.compute(mockRequest);

        // Verify that the ComputeEngine's compute method was called with an empty list
        verify(mockComputeEngine).compute(List.of());

        // Assert that the result is successful (assuming empty input is valid)
        assertEquals(ComputeResult.SUCCESS, result);
    }
}


