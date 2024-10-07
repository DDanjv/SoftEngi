package api2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.List;
public class DataStoreEmpty implements DataStore{

    private input Received;
    private output send;
    private File myObj = new File("filedata.txt");

    public DataStoreEmpty (input Received){
        if (Received == null){
            throw new IllegalArgumentException("Received input must not be null.");
        }
        this.Received = Received;
    }

    @Override
    public Iterable<Integer> read(input input) {
        if (input == null) {
            throw new IllegalArgumentException("Input must not be null.");
        }
        try{
            throw new UnsupportedOperationException("cant read");
        } catch (UnsupportedOperationException e) {
            throw new IllegalStateException("Read Operation not supported", e);
        }
    }
    @Override
    public WriteResult appendSingleResult(output output, String result) {
        if (output == null || result == null) {
            throw new IllegalArgumentException("Output and result must not be null.");
        }
        try (PrintWriter pw = new PrintWriter(myObj)) {
            pw.print(output.getOutputList());
        } 
        catch (FileNotFoundException e) {
            throw new UnsupportedOperationException("cant append'");
        }
        throw new UnsupportedOperationException("cant append'");
    }
