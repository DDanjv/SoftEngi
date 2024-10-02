package api2;
import java.util.List;

public class input implements InputConfig {
    private List<Integer> inputList;
    
    public input(List<Integer> inputList) {
        this.inputList = inputList;
    }

    public List<Integer> getInputList() {
        return inputList;
    }

    public void setInputList(List<Integer> inputList) {
        this.inputList = inputList;
    }

    public void addItem(Integer item) {
        this.inputList.add(item);
    }
}