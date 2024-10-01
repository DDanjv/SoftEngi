package api2;
public class ComputeRequest {
	
	private static final char DEFAULT_DELIMITER = ';';

	private final input inputConfig;
	private final output outputConfig;
	private final char delimiter;
	
	public ComputeRequest(input inputConfig, output outputConfig) {
		this(inputConfig, outputConfig, DEFAULT_DELIMITER); // default delimiter: ;
	}
	
	public ComputeRequest(input inputConfig, output outputConfig, char delimiter) {
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

	public output getOutputConfig() {
		return outputConfig;
	}

}
