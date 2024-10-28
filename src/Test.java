import java.util.ArrayList;
import java.util.Arrays;

import api2.ComputationCoordinatorEmpty;
import api2.ComputeEngine;
import api2.ComputeEngineEmpty;
import api2.ComputeRequest;
import api2.ComputeResult;
import api2.DataStore;
import api2.DataStoreEmpty;
import api2.input;

public class Test {
	public static void main(String[] args) { 
    DataStore data = new DataStoreEmpty(new input(new ArrayList<>())); 
        ComputeEngine engine = new ComputeEngineEmpty(null);
        ComputationCoordinatorEmpty core = new ComputationCoordinatorEmpty(data,engine);
        ComputeRequest user = new ComputeRequest(new input(new ArrayList<>(Arrays.asList(1, 2, 3))), null);
        System.out.println("e");
        ComputeResult res = core.compute(user);

  }
}
