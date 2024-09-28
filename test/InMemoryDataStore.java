import api2.DataStore;
import api2.WriteResult;

public class InMemoryDataStore {

    public WriteResult attachSingleResult(InMemoryOutput output, String result) {
        output.addOutput(result);
        return null;//fix dis
    }

    public void processData(InMemoryInput input, InMemoryOutput output) {
        for (Integer data : input.getInputData()) {
            String result = String.valueOf(data);
            attachSingleResult(output, result);
        }
    }
}
