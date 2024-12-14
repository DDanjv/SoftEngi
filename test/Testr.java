import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import api2.ComputationCoordinatorEmpty;
import api2.DataStore;
import api2.ComputeEngine;
import api2.DataStoreEmpty;
import api2.Input;
import api2.ComputeEngineEmpty;
import api2.ComputeResult;
import api2.ComputeRequest;


public class Testr {
   
    @Test
    public void testComputeWithEmptyInputList() {
        DataStore data = new DataStoreEmpty(new Input(new ArrayList<>()));
        ComputeEngine engine = new ComputeEngineEmpty(null);
        ComputationCoordinatorEmpty core = new ComputationCoordinatorEmpty(data, engine);
        ComputeRequest user = new ComputeRequest(new Input(new ArrayList<>()), null);
        ComputeResult result = core.compute(user);

        // Assert
        assertNotNull(result); // assert that the result is not null
		assertEquals("api2.ComputeResult$$Lamb", result.toString().substring(0,24));
		// Expecting failure when input list is empty
    }
}
