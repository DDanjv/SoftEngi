package api2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStoreFile implements DataStore {

    private File inputFile;
    private File outputFile;

    public DataStoreFile(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @Override
    public Iterable<Integer> read(InputConfig inputConfig) {
        List<Integer> inputNumbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
            //Assuming vaild Int
            int number = Integer.parseInt(line.trim());
                inputNumbers.add(number);
            }
        } catch (IOException e) {
            e.printStackTrace();  // Handle I/O exceptions appropriately
        }

        return inputNumbers;
    }

    @Override
    public WriteResult appendSingleResult(OutputConfig output, String result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
            writer.write(result);
            writer.newLine();
            return WriteResult.SUCCESS;
        } catch (IOException e) {
            e.printStackTrace();  // Handle the exception properly in a real scenario
            return WriteResult.FAILURE;
        }
    }
}


