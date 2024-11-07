import api2.ComputationCoordinatorEmpty;
import api2.ComputationServiceGrpc.ComputationServiceImplBase;
import api2.ComputeEngine;
import api2.DataStore;
import api2.ComputeRequest;
public class ComputationCordimpl extends ComputationServiceImplBase{

    private DataStore Datastore; // for api 2
    private ComputeEngine engine; // for api 3 

    public ComputationCordimpl(DataStore Datastore, ComputeEngine engine){
        this.Datastore = Datastore;
        this.engine = engine;
    }
    public void compute(api2.ComputationServiceOuterClass.ComputeRequest request,
        io.grpc.stub.StreamObserver<api2.ComputationServiceOuterClass.ComputeResponse> responseObserver) {
            ComputationCoordinatorEmpty a = new ComputationCoordinatorEmpty(Datastore, engine);
            ComputeRequest b = new ComputeRequest(null, null);
            a.compute(request.getObj());
    }
}
