package api2;

public class ComputeEngineEmpty implements ComputeEngine {
    private InputConfig input ;
    public ComputeEngineEmpty (InputConfig input){
        this.input = input;
    }
    @Override
    public String compute(int input) {
        throw new UnsupportedOperationException("Unimplemented method 'compute'");
    }
    
}
