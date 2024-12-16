import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import api.ComputationCoordinator;
import api.ComputationCoordinatorEmpty;
import api.ComputationCoordinatorfast;
import api.ComputeEngine;
import api.ComputeEngineEmpty;
import api.ComputeEngineFast;
import api.ComputeRequest;
import api.ComputeResult;
import api.DataStore;
import api.DataStoreEmpty;
import api.Input;
import api.InputConfig;
import api.Output;
import api.OutputConfig;

public class BottleneckTest {

    public static void main(String[] args) {
        runFastcord();
        runFasteng();


    }
    private static void runFasteng(){
        System.gc();
        int listSize = 20000000; 
        List<Integer> inputList = generateLargeNumbers(listSize);

        ComputeEngineEmpty engine = new ComputeEngineEmpty(new Input(null));

        long startTime = System.currentTimeMillis();
        String result = engine.compute(inputList);
        long endTime = System.currentTimeMillis();
        int total = (int)(endTime - startTime);

        System.gc();

        int listSizef = 20000000; 
        List<Integer> inputListf = generateLargeNumbers(listSizef);

        ComputeEngineFast enginefast = new ComputeEngineFast(new Input(null));

        long startTimefast = System.currentTimeMillis();
        String resultfast = engine.compute(inputListf);
        long endTimefast = System.currentTimeMillis();
        int total2 = (int)(endTimefast - startTimefast);
        System.out.println("--------------------------------------");
        System.out.println("time : " + (endTime - startTime) + " milliseconds");
        System.out.println("time : " + (endTimefast - startTimefast) + " milliseconds");
        System.out.println("Time shaven : " + (total - total2) + " milliseconds");
        System.out.println("--------------------------------------");
        System.gc();
    }
    private static void runFastcord(){

        System.gc();

        int listSize = 20000000;
        List<Integer> inputList = generateLargeNumbers(listSize);

        DataStore dataStore = new DataStoreEmpty(null);
        ComputeEngine engine = new ComputeEngineEmpty(null);
        ComputationCoordinator coordinator = new ComputationCoordinatorEmpty(dataStore, engine);
        Input inputConfig = new Input(inputList); 
        Output outputConfig = new Output("output.txt"); 
        ComputeRequest request = new ComputeRequest(inputConfig, outputConfig);
        long startTime = System.currentTimeMillis();
        ComputeResult result = coordinator.compute(request);
         long endTime = System.currentTimeMillis();
        int totalEmpty = (int)(endTime - startTime);

        System.gc();


        int listSizef = 2000000;
        List<Integer> inputListf = generateLargeNumbers(listSizef);
         
        DataStore dataStoref = new DataStoreEmpty(null);
        ComputeEngine enginef = new ComputeEngineEmpty(new Input(null));
        ComputationCoordinatorfast coordinatorfast = new ComputationCoordinatorfast(dataStoref,enginef);

        Input inputConfigf = new Input(inputListf);
        Output outputConfigf = new Output("output.txt");
        ComputeRequest requestf = new ComputeRequest(inputConfigf, outputConfigf);
         long startTimef = System.currentTimeMillis();
         coordinatorfast.compute(requestf);
         long endTimef = System.currentTimeMillis();
         int totalFast = (int)(endTimef - startTimef);

         System.out.println("--------------------------------------");
         System.out.println("Coord Time : " + (endTime - startTime) + " milliseconds");

        System.out.println("Coord Time fast : " + (endTimef - startTimef) + " milliseconds");
        
        System.out.println("Time shaven cord : " + (totalEmpty - totalFast) + " milliseconds");
        System.out.println("--------------------------------------");
        System.gc();
    }
    private static List<Integer> generateLargeNumbers(int size) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
             list.add(random.nextInt(9999000) + 1000); 
        }
        return list;
    }
}
