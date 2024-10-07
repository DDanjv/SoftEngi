package api2;
import java.util.List;

public class ComputationCoordinatorEmpty implements ComputationCoordinator {

    private DataStore Coordinate; // for api 2
    private ComputeEngine api3u; // for api 3 
    public ComputationCoordinatorEmpty(DataStore Coordinate, ComputeEngine api3u){
        //request is not null and contains valid inputConfig
        if(dataStore == null || computeEngine == null) {
            throw new IllegalArgumentException("DataStore and Compute Engine must not be null.");
        }
        this.Coordinate = Coordinate;
        this.api3u = api3u;
    }
    @Override
    public ComputeResult compute(ComputeRequest request) {
        if (request == null || request.getInputConfig() == null){
            throw new IllegalArgumentException("ComputeRequest and its InputConfig must not be null.");
        }
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
