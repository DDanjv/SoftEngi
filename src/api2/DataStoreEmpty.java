package api2;

import java.util.ArrayList;
import java.util.List;

public class DataStoreEmpty implements DataStore {

    private List<Integer> storedInput;   // For storing input integers
    private List<String> storedResults;  // For storing computation results

    public DataStoreEmpty() {
        this.storedInput = new ArrayList<>();
        this.storedResults = new ArrayList<>();
    }

    @Override
    public Iterable<Integer> read(InputConfig inputConfig) {
        return storedInput;
    }

    @Override
    public WriteResult appendSingleResult(OutputConfig output, String result) {
        // Add the result to the in-memory result list
        storedResults.add(result);
        return WriteResult.SUCCESS;
    }

    // Method to get stored results for testing
    public List<String> getStoredResults() {
        return storedResults;
    }
}
