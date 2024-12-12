import java.util.List;

public class InMemoryDataStore {

    private final InMemoryInput inputConfig;
    private final InMemoryOutput outputConfig;

    public InMemoryDataStore(InMemoryInput inputConfig, InMemoryOutput outputConfig) {
        this.inputConfig = inputConfig;
        this.outputConfig = outputConfig;
    }

    // Simulates reading input data and writing output data
    public void process() {
        List<Integer> inputData = inputConfig.getInputList();
        for (Integer input : inputData) {
          // converting integers to strings for output
            String processedOutput = "Processed: " + input;
            outputConfig.setOutput(processedOutput);
        }
    }

    // For retrieving the output data after processing
    public String getProcessedOutput() {
        return outputConfig.getOutput();
    }
}
