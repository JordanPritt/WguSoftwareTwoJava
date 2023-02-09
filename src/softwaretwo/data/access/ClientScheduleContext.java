package softwaretwo.data.access;

import java.sql.Connection;
import java.sql.DriverManager;

public class ClientScheduleContext {
    private static final String protocol = "jdbc";
    private static final String vendor = ":mysql:";
    private static final String location = "//localhost/";
    private static final String databaseName = "client_schedule";
    private static final String url = protocol + vendor + location + databaseName + "?connectionTimeZone=SERVER";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String userName = "sqlUser";
    private static final String password = "Passw0rd!";

    public static Connection connection;

    public static void OpenConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Successfully connected to database.");
        } catch (Exception ex) {
            System.out.println("Could not connect to database: " + ex.getMessage());
        }
    }

    public static void CloseConnection() {
        try {
            connection.close();
            System.out.println("Successfully closed database connection.");
        } catch (Exception ex) {
            System.out.println("Could not close connection: " + ex.getMessage());
        }
    }
}
