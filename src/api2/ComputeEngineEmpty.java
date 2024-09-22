package api2;

    
public class ComputeEngineEmpty implements ComputeEngine {
    private ComputeEngineEmpty compute;
    public ComputeEngineEmpty (ComputeEngineEmpty compute){
        this.compute = compute;
    }
    @Override
    public String compute(int value) {
        throw new UnsupportedOperationException("Unimplemented method 'compute'");
    }
    
}
