import io.grpc.stub.StreamObserver;
import api.ComputationCoordinatorEmpty;
import api.ComputationServiceGrpc;
import api.ComputationServiceOuterClass;
import api.ComputeEngineEmpty;
import api.ComputeRequest;
import api.DataStoreEmpty;
import api.ComputationServiceOuterClass.ComputeResponse;
import api.ComputationServiceOuterClass.ComputeResponse.Builder;

public class ComputationCordimpl extends ComputationServiceGrpc.ComputationServiceImplBase {
    // call coordaites
    DataStoreEmpty store = new DataStoreEmpty(null);
    ComputeEngineEmpty engine = new ComputeEngineEmpty(null);
    ComputationCoordinatorEmpty cord = new ComputationCoordinatorEmpty(store,engine);
    @Override
    public void compute(ComputationServiceOuterClass.ComputeRequest requestg, StreamObserver<ComputationServiceOuterClass.ComputeResponse> out) {
    Builder result;
    try {
         api.Input actinput = new api.Input(requestg.getObj().getListList());
         api.Output actoutput = new api.Output(requestg.getObj2().getOut());
         ComputeRequest hold = new ComputeRequest(actinput,actoutput);
         cord.compute(hold);
        result = api.ComputationServiceOuterClass.ComputeResponse.newBuilder().setResult("true");
        System.out.println("done with computation");
    } catch (Exception e) {
        e.printStackTrace();
        result = ComputeResponse.newBuilder().setResult("false");
    }
    // convent from grpc class back into class
    // in respone summor or fail if respone also send compute result.
    // send back the respones out.onNext();
    out.onNext(result.build());
    out.onCompleted();
    }
}