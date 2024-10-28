package api2;
import java.util.List;
import java.util.concurrent.Callable;
// for threading 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ComputationCoordinatorEmpty implements ComputationCoordinator {

    private DataStore Coordinate; // for api 2
    private ComputeEngine api3u; // for api 3 
    private static final int numofthreads = 4;

    public ComputationCoordinatorEmpty(DataStore Coordinate, ComputeEngine api3u){
        this.Coordinate = Coordinate;
        this.api3u = api3u;
    }
    @Override
    public ComputeResult compute(ComputeRequest request) {
            ExecutorService threadpool = Executors.newFixedThreadPool(numofthreads);
            //send to compute engine 
            try {
            	List<Integer> Userinput = request.getInputConfig().getInputList();
                if (Userinput == null) {
                    System.err.println("User input list is null.");
                    return ComputeResult.FAILURE;
                }
                else {
                	System.out.print("Received:");
                }
                Callable<ComputeResult> taskforthread = () -> {
                    String compout = api3u.compute(Userinput);
                    if (compout == null) {
                        System.err.println("ComputeEngine returned null.");
                        return ComputeResult.FAILURE;
                    }
                    else {
                        System.out.print("output:"+compout+"\n");
                    }
                    Coordinate.appendSingleResult(null,compout);
                    return ComputeResult.SUCCESS;
                };
                Future<ComputeResult> future = threadpool.submit(taskforthread);

            // Await completion
                return future.get();
            } catch (Exception e) {
                System.err.println("error occurred at: " + e.getMessage());
                return ComputeResult.FAILURE;
            } finally {
                threadpool.shutdown();
                try {
                    if (!threadpool.awaitTermination(5, TimeUnit.SECONDS)) {
                        threadpool.shutdownNow();
                    }
                } catch (InterruptedException ex) {
                    threadpool.shutdownNow();
                    Thread.currentThread().interrupt();
                }
            }
    }
}
