package api2;
public interface WriteResult {
	WriteResultStatus getStatus();
	
	public static enum WriteResultStatus {
		SUCCESS,
		FAILURE;
	}
}
