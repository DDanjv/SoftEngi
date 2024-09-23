package api2.InputConfig;
package api2.OutputConfig;

public class InMemoryDataStore {

    public WriteResult attachSingleResult(InMemoryOutput output, String result) {
        output.addOutput(result);
        return WriteResult.success();
    }

    public void processData(InMemoryInput input, InMemoryOutput output) {
        for (Integer data : input.getInputData()) {
            String result = String.valueOf(data);
            attachSingleResult(output, result);
        }
    }
}
