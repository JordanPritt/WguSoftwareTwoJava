package softwaretwo.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Logger utility for tracking login activity.
 */
public class LoginLogger {
    /**
     * Log user login activity.
     *
     * @param log the log to track.
     */
    public void LogUserActivity(LoginLogModel log) {
        try {
            // create file object and file if not exist
            File logFile = new File("login_activity.txt");
            // write log to file
            FileWriter fw = new FileWriter(logFile, true);
            fw.append("Username: ")
                    .append(log.getUsername())
                    .append(" | ")
                    .append("Attempt: ")
                    .append(String.valueOf(log.getAttemptCount()))
                    .append(" | ")
                    .append(log.getTimestamp())
                    .append(" | was success:")
                    .append(String.valueOf(log.isSuccessful()))
                    .append("\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Generates a timestamp for now.
     *
     * @return a timestamp string.
     */
    public String getTimeStamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        return sdf.format(date);
    }
}
