package api2;

public class ComputationCoordinatorEmpty implements ComputationCoordinator {

    private DataStore Coordinate; // for api 2
    private ComputeEngine api3u; // for api 3 
    public ComputationCoordinatorEmpty(DataStore Coordinate, ComputeEngine api3u){
        this.Coordinate = Coordinate;
        this.api3u = api3u;
    }
    @Override
    public ComputeResult compute(ComputeRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'compute'");
    }
    
}
