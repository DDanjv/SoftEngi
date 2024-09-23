import java.util.ArrayList;
import java.util.List;

public class InMemoryOutput implements OutputConfig {
    private final List<String> outputData;

    public InMemoryOutput() {
        this.outputData = new ArrayList<>();
    }

    public List<String> getOutputData() {
        return outputData;
    }

    public void addOutput(String result) {
        outputData.add(result);
    }
}
