import java.util.List;

public class InMemoryDataStore {

    private final InMemoryInput inputConfig;
    private final InMemoryOutput outputConfig;
    private String data;

    public InMemoryDataStore(InMemoryInput inputConfig, InMemoryOutput outputConfig) {
        this.inputConfig = inputConfig;
        this.outputConfig = outputConfig;
    }

    // Simulates reading input data and writing output data
    public void appendSingleResult(InMemoryOutput output, String result) {
        this.data = output.getOutput();
    };

    // For retrieving the output data after processing
    public String read() {
        return data;
    }
}
