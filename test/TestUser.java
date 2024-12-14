import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import api.ComputationCoordinatorEmpty;
import api.ComputeResult;
import api.ComputeRequest;
import api.Input;
import api.Output;


public class TestUser {

	private final ComputationCoordinatorEmpty coordinator;

	public TestUser(ComputationCoordinatorEmpty coordinator) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) {
		char delimiter = ';';
		String inputPath = "test" + File.separatorChar + "testInputFile.test";
		

		List<Integer> inputData = loadInputData(inputPath);
		Input inputConfig = new Input(inputData);
		// Create the ComputeRequest with the input

		ComputeRequest computeRequest = new ComputeRequest(inputConfig, new Output(outputPath));

		// Call the compute method
		ComputeResult result = coordinator.compute(computeRequest);

		//Handle the output based on result

		if (result == ComputeResult.SUCCESS) {
			writeOutputToFile(outputPath, "Computation successful");
		} else {
			writeOutputToFile(outputPath, "Computation failed");
		}
	}

	// Reads input data from file, parse into list of integers
	private List<Integer> loadInputData(String inputPath) {
		try{
			return Files.lines(Paths.get(inputPath))
					.map(Integer::parseInt)
					.collect(Collectors.toList());
		} catch (NumberFormatException | IOException e) {
			System.err.println("Error parsing data: " + e.getMessage());
			return new ArrayList<>();
		}
		
	}
		//output message to a file
	private void writeOutputToFile(String outputPath, String output) {
		try {
			Files.write(Paths.get(outputPath), output.getBytes());
			System.out.println("Output written to " + outputPath + ": " + output);
		} catch (IOException e) {
			System.err.println("Error writing output: " + e.getMessage());
		}
	}

}


