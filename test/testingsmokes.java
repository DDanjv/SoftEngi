import api2.DataStoreEmpty;
import api2.WriteResult;
import api2.Input;
import api2.Output;

public class testingsmokes {
    public static void main(String[] args) throws Exception {
        DataStorePrototypeSmoke tester = new DataStorePrototypeSmoke();
        ComputeEnginePrototypeSmoke testcomp = new ComputeEnginePrototypeSmoke();
        tester.setUp();
        WriteResult result = tester.testAppendSingleResult_Success();
        System.out.println("Test result status: " + result.getStatus());
        
    }
}
