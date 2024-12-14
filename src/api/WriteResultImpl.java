package api;

public class WriteResultImpl implements WriteResult {
    private WriteResultStatus status;

    public WriteResultImpl(WriteResultStatus status) {
        this.status = status;
    }

    @Override
    public WriteResultStatus getStatus() {
        return this.status;
    }
}