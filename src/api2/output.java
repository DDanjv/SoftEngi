package api2;

import java.util.List;

public class Output implements OutputConfig{
    private List<String> outputList;

    public Output(List<String> outputList) {
        this.outputList = outputList;
    }

    public List<String> getOutputList() {
        return outputList;
    }

    public void setOutputList(List<String> outputList) {
        this.outputList = outputList;
    }

    public void addItem(String item) {
        this.outputList.add(item);
    }
}
