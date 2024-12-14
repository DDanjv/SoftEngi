package api;

public class Output implements OutputConfig{
    private String outputL;

    public Output(String outputList) {
        this.outputL = outputList;
    }

    public String getOutput() {
        return outputL;
    }

    public void setOutput(String outputList) {
        this.outputL = outputList;
    }
}
