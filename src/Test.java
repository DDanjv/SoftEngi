import java.util.ArrayList;
import java.util.Arrays;

import api2.ComputationCoordinatorEmpty;
import api2.ComputeEngine;
import api2.ComputeEngineEmpty;
import api2.ComputeRequest;
import api2.ComputeResult;
import api2.DataStore;
import api2.DataStoreEmpty;
import api2.Input;
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
