import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import api.ComputeEngineEmpty;
import api.ComputeEngineFast;
import api.Input;

public class BottleneckTest {

    public static void main(String[] args) {
        int listSize = 5000; 
        List<Integer> inputList = generateLargeNumbers(listSize);

        ComputeEngineEmpty engine = new ComputeEngineEmpty(new Input(null));

        long startTime = System.currentTimeMillis();
        String result = engine.compute(inputList);
        long endTime = System.currentTimeMillis();
        int total = (int)(endTime - startTime);

        System.out.println("time : " + (endTime - startTime) + " milliseconds");

        inputList = generateLargeNumbers(listSize);

        ComputeEngineFast enginefast = new ComputeEngineFast(new Input(null));

        long startTimefast = System.currentTimeMillis();
        String resultfast = engine.compute(inputList);
        long endTimefast = System.currentTimeMillis();
        int total2 = (int)(endTimefast - startTimefast);

        System.out.println("time : " + (endTimefast - startTimefast) + " milliseconds");
        System.out.println("Time shaven : " + (total - total2) + " milliseconds");



    }

    private static List<Integer> generateLargeNumbers(int size) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
             list.add(random.nextInt(9999000) + 1000); // Generates large numbers
        }
        return list;
    }
}
