import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import api.ComputationCoordinatorEmpty;
import api.ComputeEngine;
import api.ComputeEngineEmpty;
import api.ComputeRequest;
import api.ComputeResult;
import api.DataStore;
import api.InputConfig;
import api.OutputConfig;
import api.Input;
import api.Output;

public class ComputationCoordinatorPrototypeSmoke{
    
    @Mock
    private DataStore data;
    @Mock
    private ComputeEngine comp;

    private ComputationCoordinatorEmpty cord;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cord = new ComputationCoordinatorEmpty(data,comp);
    }
    @Test
    boolean runcompute() throws FileNotFoundException{
        ComputeRequest mockRequest = mock(ComputeRequest.class);
        Input mockInputConfig = mock(Input.class);
        Output mockOutputConfig = mock(Output.class);

        List<Integer> inputList = Arrays.asList(1, 2, 3, 4);
        when(mockRequest.getInputConfig()).thenReturn(mockInputConfig);
        when(mockInputConfig.getInputList()).thenReturn(inputList);
        when(mockRequest.getOutputConfig()).thenReturn(mockOutputConfig);
        when(comp.compute(inputList)).thenReturn("Result123");

        // Call the compute method
        ComputeResult result = cord.compute(mockRequest);

        // Verifications and assertions
        assertEquals(ComputeResult.SUCCESS, result, "ComputeResult should be SUCCESS");
        return true;  
    }
}