//stuff from api2
import api2.DataStore;
import api2.DataStorePrototype;
import api2.InputConfig;
import api2.OutputConfig;
import api2.WriteResult;
import api2.input;
import api2.output;
import api2.WriteResult.WriteResultStatus;
//mockito
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
//junit
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class DataStorePrototypeSmoke {

    // var setup 
    private DataStorePrototype dataStorePrototype;
    private DataStore mockedApi;
    private input mockedInputConfig;
    private output mockedOutputConfig;
    private WriteResult mockedWriteResult;

    // Initialization
    @Before
    public void setUp() {
        dataStorePrototype = new DataStorePrototype(); // object
        mockedApi = mock(DataStore.class);
        mockedInputConfig = mock(input.class);
        mockedOutputConfig = mock(output.class);
        mockedWriteResult = mock(WriteResult.class);
    }

    @Test
    public void testPrototype() throws FileNotFoundException {
        // Set up the behavior for the mock
        when(mockedApi.read(mockedInputConfig)).thenReturn(Arrays.asList(1, 2, 3)); // Mock reading integers
        when(mockedApi.appendSingleResult(mockedOutputConfig, "1")).thenReturn(mockedWriteResult);
        when(mockedApi.appendSingleResult(mockedOutputConfig, "2")).thenReturn(mockedWriteResult);
        when(mockedApi.appendSingleResult(mockedOutputConfig, "3")).thenReturn(mockedWriteResult);
        when(mockedWriteResult.getStatus()).thenReturn(WriteResultStatus.SUCCESS);

        // Call the method under test
        dataStorePrototype.prototype(mockedApi);

        // Verify that the read method was called with the correct inputConfig
        verify(mockedApi).read(mockedInputConfig);

        // Verify that appendSingleResult was called with the correct results for each integer
        verify(mockedApi).appendSingleResult(mockedOutputConfig, "1");
        verify(mockedApi).appendSingleResult(mockedOutputConfig, "2");
        verify(mockedApi).appendSingleResult(mockedOutputConfig, "3");

        // Check the write result status
        assertEquals(WriteResultStatus.SUCCESS, mockedWriteResult.getStatus());
    }
}
