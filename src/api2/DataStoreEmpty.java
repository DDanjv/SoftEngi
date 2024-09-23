package api2;

public class DataStoreEmpty implements DataStore{
    private DataStoreEmpty storedata;
    public DataStoreEmpty (DataStoreEmpty storedtata){
        this.storedata = storedtata;
    }
    @Override
    public Iterable<Integer> read(InputConfig input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }
    @Override
    public WriteResult appendSingleResult(OutputConfig output, String result) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'appendSingleResult'");
    }
    

}
