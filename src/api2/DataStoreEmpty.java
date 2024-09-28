package api2;

public class DataStoreEmpty implements DataStore{
    private InputConfig Received;
    private OutputConfig send;

    public DataStoreEmpty (InputConfig Received){
        this.Received = Received;
    }
    @Override
    public Iterable<Integer> read(InputConfig input) {
        throw new UnsupportedOperationException("cant read");
    }
    @Override
    public WriteResult appendSingleResult(OutputConfig output, String result) {
        throw new UnsupportedOperationException("cant append'");
    }
    

}
