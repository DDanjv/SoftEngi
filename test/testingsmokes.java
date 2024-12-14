import api2.DataStoreEmpty;
import api2.WriteResult;
import api2.input;
import api2.output;

public class testingsmokes {
    public static void main(String[] args) throws Exception {
        DataStorePrototypeSmoke tester = new DataStorePrototypeSmoke();
        ComputeEnginePrototypeSmoke testcomp = new ComputeEnginePrototypeSmoke();
        tester.setUp();
        WriteResult result = tester.testAppendSingleResult_Success();
        System.out.println("Test result status: " + result.getStatus());
        
    }
}
