package softwaretwo.tests;

import softwaretwo.utilities.LoginLogModel;
import softwaretwo.utilities.LoginLogger;

import java.io.File;

public class LoginLoggerTests {
    public static boolean logUserActivityTest(){
        LoginLogger logger = new LoginLogger();
        LoginLogModel mock = new LoginLogModel("server test", 1, logger.getTimeStamp(), false);
        logger.LogUserActivity(mock);
        // check that log file exists
        File file = new File("login_activity.txt");
        return file.exists();
    }
}
