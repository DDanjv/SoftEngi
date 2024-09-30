package api2;
public class ComputeRequest {
	
	private static final char DEFAULT_DELIMITER = ';';

	private final input inputConfig;
	private final OutputConfig outputConfig;
	private final char delimiter;
	
	public ComputeRequest(input inputConfig, OutputConfig outputConfig) {
		this(inputConfig, outputConfig, DEFAULT_DELIMITER); // default delimiter: ;
	}
	
	public ComputeRequest(input inputConfig, OutputConfig outputConfig, char delimiter) {
		this.inputConfig = inputConfig;
		this.outputConfig = outputConfig;
		this.delimiter = delimiter;
	}
	
	public char getDelimiter() {
		return delimiter;
	}

	public input getInputConfig() {
		return inputConfig;
	}

	public OutputConfig getOutputConfig() {
		return outputConfig;
	}

}
