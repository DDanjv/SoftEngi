//stuff from api2
import api2.ComputationCoordinator;
import api2.ComputationCoordinatorPrototype;
import api2.ComputeRequest;
import api2.ComputeResult;
import api2.ComputeResult.ComputeResultStatus;
import api2.InputConfig;
import api2.OutputConfig;
//mockito
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
//junit
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ComputationCoordinatorPrototypeSmoke{

    // var setup 
    private ComputationCoordinatorPrototype coordinatorPrototype;
    private ComputationCoordinator mockedApi;
    private InputConfig mockedInputConfig;
    private OutputConfig mockedOutputConfig;
    private ComputeRequest mockedRequest;
    private ComputeResult mockedResult;

    //Initialization
    @Before
    public void setUp() { //create mock of each
        coordinatorPrototype = new ComputationCoordinatorPrototype();//obj
        mockedApi = mock(ComputationCoordinator.class);
        mockedInputConfig = mock(InputConfig.class);
        mockedOutputConfig = mock(OutputConfig.class);
        mockedRequest = new ComputeRequest(mockedInputConfig, mockedOutputConfig, ',');
        mockedResult = mock(ComputeResult.class);
    }


    @Test
    public void testPrototype() {
        // Set up the behavior for the mock
        when(mockedApi.compute(mockedRequest)).thenReturn(mockedResult);
        when(mockedResult.getStatus()).thenReturn(ComputeResult.SUCCESS.getStatus()); // Assuming ComputeStatus has a constructor that takes a boolean

        // Call the method under test
        coordinatorPrototype.prototype(mockedApi);

        // Verify that the compute method was called with the correct request
        verify(mockedApi).compute(mockedRequest);

        // Check the result status
        assertTrue(mockedResult.getStatus().isSuccess());
    }
}
