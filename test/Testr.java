import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import api.ComputationCoordinatorEmpty;
import api.DataStore;
import api.ComputeEngine;
import api.DataStoreEmpty;
import api.Input;
import api.ComputeEngineEmpty;
import api.ComputeResult;
import api.ComputeRequest;


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
		assertEquals("api.ComputeResult$$Lambd", result.toString().substring(0,24));
		// Expecting failure when input list is empty
    }
}
