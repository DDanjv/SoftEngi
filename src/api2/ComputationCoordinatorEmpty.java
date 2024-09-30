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
            //send to compute engine 
            input Userinput = request.getInputConfig();
            
            OutputConfig compout = api3u.compute(Userinput.getInputList()); 
            //sends to data store
            DataStore.appendSingleResult(compout,"a"); //need the other two API's in the other two apis to finish
            return null;
    }
}
