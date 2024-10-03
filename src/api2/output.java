package api2;
import java.util.List;

public class output implements OutputConfig{
    private List<Integer> outputL;

    public output(List<Integer> outputList) {
        this.outputL = outputList;
    }

    public List<Integer> getOutputList() {
        return outputL;
    }

    public void setOutputList(List<Integer> outputList) {
        this.outputL = outputList;
    }

    public void addItem(Integer  item) {
        this.outputL.add(item);
    }
}
