package softwaretwo.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
    public static void LogUserActivity(LoginLogModel log) {
        try {
            // create file object and file if not exist
            File logFile = new File("login_activity.txt");
            // write log to file
            FileWriter fw = new FileWriter(logFile, true);
            fw.append("Username: ")
                    .append(String.format("%-25s", log.getUsername()))
                    .append(" | ")
                    .append("Attempt: ")
                    .append(String.format("%-3s", (log.getAttemptCount())))
                    .append(" | ")
                    .append("Timestamp: ")
                    .append(log.getTimestamp())
                    .append(" | successful:")
                    .append(String.format("%-5s", log.isSuccessful()))
                    .append(" | reason: ")
                    .append(log.getSuccessMessage())
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
    public static String getTimeStamp() {
        ZonedDateTime date = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        return date.withZoneSameInstant(ZoneId.of("UTC")).toString();
    }
}
