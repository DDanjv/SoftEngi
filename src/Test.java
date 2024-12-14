import java.util.ArrayList;
import java.util.Arrays;
import api.ComputationCoordinatorEmpty;
import api.ComputeEngine;
import api.ComputeEngineEmpty;
import api.ComputeRequest;
import api.ComputeResult;
import api.DataStore;
import api.DataStoreEmpty;
import api.Input;

public class Test {
	public static void main(String[] args) {
    DataStore data = new DataStoreEmpty(new Input(new ArrayList<>())); 
        ComputeEngine engine = new ComputeEngineEmpty(null);
        ComputationCoordinatorEmpty core = new ComputationCoordinatorEmpty(data,engine);
        ComputeRequest user = new ComputeRequest(new Input(new ArrayList<>(Arrays.asList(1, 2, 3))), null);
        System.out.println("e");
        @SuppressWarnings("unused")
        ComputeResult res = core.compute(user);

  }
}
