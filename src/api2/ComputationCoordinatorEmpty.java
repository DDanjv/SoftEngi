package api2;

public class ComputationCoordinatorEmpty implements ComputationCoordinator {

    private ComputationCoordinatorEmpty Coordinate;
    public ComputationCoordinatorEmpty(ComputationCoordinatorEmpty Coordinate){
        this.Coordinate = Coordinate;
    }
    @Override
    public ComputeResult compute(ComputeRequest request) {
        throw new UnsupportedOperationException("Unimplemented method 'compute'");
    }
    
}
