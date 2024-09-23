import java.util.List;

public class InMemoryInput implements InputConfig {
    private final List<Integer> inputData;

    public InMemoryInput(List<Integer> inputData) {
        this.inputData = inputData;
    }

    public List<Integer> getInputData() {
        return inputData;
    }
}
