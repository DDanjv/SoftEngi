import java.util.List;
import api2.InputConfig;

public class InMemoryInput implements InputConfig {
    private final List<Integer> inputData;

    public InMemoryInput(List<Integer> inputData) {
        this.inputData = inputData;
    }

    public List<Integer> getInputData() {
        return inputData;
    }
}
