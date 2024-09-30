package api2;

import java.util.List;

public class ComputeEngineEmpty implements ComputeEngine {
    private InputConfig input ;
    public ComputeEngineEmpty (InputConfig input){
        this.input = input;
    }
    @Override
    public String compute(List<String> input) {
        throw new UnsupportedOperationException("Unimplemented method 'compute'");
    }
    
}
