package api2;
import java.util.List;

public class ComputationCoordinatorEmpty implements ComputationCoordinator {

    private DataStore Coordinate; // for api 2
    private ComputeEngine api3u; // for api 3 
    public ComputationCoordinatorEmpty(DataStore Coordinate, ComputeEngine api3u){
        this.Coordinate = Coordinate;
        this.api3u = api3u;
    }
    @Override
    public ComputeResult compute(ComputeRequest request) {
            //send to compute engine 
            try {
                List<Integer> Userinput = request.getInputConfig().getInputList();
                String compout = api3u.compute(Userinput); 
                //sends to data store
                return ComputeResult.SUCCESS;
            } catch (Exception e) {
                return ComputeResult.FAILURE;
            }
    }
}
