package api;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComputeEngineEmpty implements ComputeEngine {
    @SuppressWarnings("unused")
    private Input input ;
    public ComputeEngineEmpty(Input input){
        this.input = input;
    }
    @Override
    public String compute(List<Integer> input) {
        List<Integer> a = new ArrayList<>();

        
        for (int i = 0; i < input.size(); i++) {
            int number = input.get(i);
            if (number > 1) {
                boolean isPrime = true;
                for (int j = 2; j <= Math.sqrt(number); j++) {
                    if (number % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    a.add(number);
                }
            }
        }

        return a.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}

