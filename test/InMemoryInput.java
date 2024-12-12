import java.util.List;
import api2.input;

public class InMemoryInput extends input {

    public InMemoryInput(List<Integer> inputList) {
        super(inputList);
    }

    @Override
    public List<Integer> getInputList() {
        return super.getInputList();
    }

    @Override
    public void setInputList(List<Integer> inputList) {
        super.setInputList(inputList);
    }

    @Override
    public void addItem(Integer item) {
        super.addItem(item);
    }
}
