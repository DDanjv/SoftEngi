package api2;

public class DataStoreEmpty implements DataStore{
    private input Received;
    private OutputConfig send;

    public DataStoreEmpty (input Received){
        this.Received = Received;
    }
    @Override
    public Iterable<Integer> read(input input) {
        throw new UnsupportedOperationException("cant read");
    }
    @Override
    public WriteResult appendSingleResult(OutputConfig output, String result) {
        throw new UnsupportedOperationException("cant append'");
    }
    

}
