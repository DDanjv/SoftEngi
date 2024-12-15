package api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComputeEngineFast implements ComputeEngine {
    @SuppressWarnings("unused")
    private Input input;

    public ComputeEngineFast(Input input) {
        this.input = input;
    }

    @Override
    public String compute(List<Integer> input) {
        int max = input.stream().max(Integer::compareTo).orElse(0);

        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = input.stream().filter(n -> n > 1 && isPrime[n]).collect(Collectors.toList());
        return primes.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}