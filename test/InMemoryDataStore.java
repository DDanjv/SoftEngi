import java.util.ArrayList;
import java.util.List;
import api.DataStore;
import api.Input;
import api.Output;
import api.WriteResult;
import api.WriteResult.WriteResultStatus;
import api.WriteResultImpl;

public class InMemoryDataStore implements DataStore {

    private InMemoryInput received;
    private InMemoryOutput send;
    private List<String> memoryStore;

    public InMemoryDataStore(InMemoryInput received) {
        this.received = received;
        this.memoryStore = new ArrayList<>();
    }

    @Override
    public String read(Input input) {
        if (memoryStore.isEmpty()) {
            return ""; // Or handle this case differently
        }
        StringBuilder sb = new StringBuilder();
        for (String line : memoryStore) {
            sb.append(line).append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public WriteResult appendSingleResult(Output output, String result) {
        send = (InMemoryOutput) output;
         if (send != null && send.getOutput() != null) {
            memoryStore.add(result + "results");
            System.out.println("Data added to in-memory store: " + result + "results");
            return new WriteResultImpl(WriteResultStatus.SUCCESS);
        } else {
            System.out.println("Output or Output string is null");
            return new WriteResultImpl(WriteResultStatus.FAILURE);
        }

    }
}
/*import java.util.ArrayList;
import java.util.List;
import api.DataStore;
import api.Input;
import api.Output;
import api.WriteResult;
import api.WriteResult.WriteResultStatus;
import api.WriteResultImpl;

public class InMemoryDataStore{

    private InMemoryInput received;
    private InMemoryOutput send;
    private List<String> memoryStore;

    public InMemoryDataStore(InMemoryInput received) {
        this.received = received;
        this.memoryStore = new ArrayList<>();
    }

    public String read(InMemoryInput input) {
        if (memoryStore.isEmpty()) {
            return "";
        }
        return input.getInputList().toString();
    }

    public WriteResult appendSingleResult(InMemoryOutput whereitsgoing, String intake) {

         if (send != null && send.getOutput() != null) {
            memoryStore.add(intake + "results");
            System.out.println("Data added to in-memory store: " + intake + "results");
            return new WriteResultImpl(WriteResultStatus.SUCCESS);
        } else {
            System.out.println("Output or Output string is null");
            return new WriteResultImpl(WriteResultStatus.FAILURE);
        }

    }
}*/
