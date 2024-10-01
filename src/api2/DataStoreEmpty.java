package api2;

import java.util.ArrayList;
import java.util.List;

public class DataStoreEmpty implements DataStore {
    
    private List<String> storedResults;  // A list to store results from ComputeEngine

    // accepts Input configuration and initiales result store
    public DataStoreEmpty(Input receivedInput) {
        this.receivedInput = receivedInput;
        this.storedResults = new ArrayList<>();
    }

    @Override
    public Iterable<Integer> read(Input input) {
        // This could be expanded, but for now throws an exception
        throw new UnsupportedOperationException("Cannot read from DataStoreEmpty");
    }

    @Override
    public WriteResult appendSingleResult(OutputConfig output, String result) {
        // Store the result from ComputeEngine
        storedResults.add(result);
        // return a successful WriteResult
        return WriteResult.SUCCESS;
    }

}
