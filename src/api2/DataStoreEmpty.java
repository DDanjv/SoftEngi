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
        this.Received = Received;
    }

    @Override
    public Iterable<Integer> read(input input) {
        throw new UnsupportedOperationException("cant read");

    @Override
    public WriteResult appendSingleResult(output output, String result) {
        try (PrintWriter pw = new PrintWriter(myObj)) {
            pw.print(output.getOutputList());
        } 
        catch (FileNotFoundException e) {
            throw new UnsupportedOperationException("cant append'");
        }
        throw new UnsupportedOperationException("cant append'");
    }

}
