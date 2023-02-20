package softwaretwo.utilities;

/**
 * A model for attempted login data used for logging.
 */
public class LoginLogModel {
    private String username;
    private int attemptCount;
    private String timestamp;
    private boolean isSuccessful;
    private String successMessage;

    /**
     * Empty constructor.
     */
    public LoginLogModel() {
    }

    /**
     * Default constructor.
     *
     * @param username     attempted username.
     * @param attemptCount attempt try number.
     * @param timestamp    current timestamp.
     * @param isSuccessful success indicator.
     * @param successMessage reason for success/failure.
     */
    public LoginLogModel(String username, int attemptCount, String timestamp, boolean isSuccessful, String successMessage) {
        this.username = username;
        this.attemptCount = attemptCount;
        this.timestamp = timestamp;
        this.isSuccessful = isSuccessful;
        this.successMessage = successMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }
}
