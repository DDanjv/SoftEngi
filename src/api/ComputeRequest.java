package api;
public class ComputeRequest {
	
	private static final char DEFAULT_DELIMITER = ';';

	private final Input inputConfig;
	private final Output outputConfig;
	private final char delimiter;
	
	public ComputeRequest(Input inputConfig, Output outputConfig) {
		this(inputConfig, outputConfig, DEFAULT_DELIMITER); // default delimiter: ;
	}
	
	public ComputeRequest(Input inputConfig, Output outputConfig, char delimiter) {
		this.inputConfig = inputConfig;
		this.outputConfig = outputConfig;
		this.delimiter = delimiter;
	}
	
	public char getDelimiter() {
		return delimiter;
	}

	public Input getInputConfig() {
		return inputConfig;
	}

	public Output getOutputConfig() {
		return outputConfig;
	}

}
