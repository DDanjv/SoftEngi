package api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ComputationCoordinatorfast implements ComputationCoordinator {

    private final DataStore datastore; 
    private final ComputeEngine engine; 
    private static final int NUM_OF_THREADS = 4; 

    public ComputationCoordinatorfast(DataStore dataStore, ComputeEngine engine) {
        this.datastore = dataStore;
        this.engine = engine;
    }
    @Override
    public ComputeResult compute(ComputeRequest request) {
        ExecutorService threadPool = Executors.newFixedThreadPool(NUM_OF_THREADS);
        try {
            List<Integer> userInput = request.getInputConfig().getInputList();
            if (userInput == null) {
                System.err.println("User input list is null .");
                return ComputeResult.FAILURE;
            }

            int chunks = userInput.size() / NUM_OF_THREADS;
            int remainder = userInput.size() % NUM_OF_THREADS;

            List<Future<String>> futures = new ArrayList<>();

            int[] extra = new int[NUM_OF_THREADS];

            int remaining = remainder;
            for (int i = 0; i < NUM_OF_THREADS; i++) {
                if (remaining > 0) {
                    extra[i] = 1; 
                    remaining--;
                } else {
                    extra[i] = 0;
                }
            }

            int start = 0;
            for (int i = 0; i < NUM_OF_THREADS; i++) {
                int end = start + chunks + extra[i];
                List<Integer> chunk = userInput.subList(start, end);
                Callable<String> task = () -> engine.compute(chunk);
                futures.add(threadPool.submit(task));
                start = end;
            }

            for (Future<String> future : futures) {
                try {
                    String result = future.get();
                    if (result == null) {
                        return ComputeResult.FAILURE;
                    }
                    synchronized (datastore) {
                        datastore.appendSingleResult(request.getOutputConfig(), result);
                    }
                } catch (Exception e) {
                    System.err.println("Error processing chunk : " + e.getMessage());
                    return ComputeResult.FAILURE;
                }
            }

            return ComputeResult.SUCCESS;
        } catch (Exception e) {
            System.err.println("Error occurred : " + e.getMessage());
            return ComputeResult.FAILURE;
        } finally {
            threadPool.shutdown();
            try {
                if (!threadPool.awaitTermination(5, TimeUnit.SECONDS)) {
                    threadPool.shutdownNow();
                }
            } catch (InterruptedException ex) {
                threadPool.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}
