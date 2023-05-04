package softwaretwo.data.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A context for communicating with the database.
 */
public class ClientScheduleContext {
    private static final String protocol = "jdbc";
    private static final String vendor = ":mysql:";
    private static final String location = "//localhost/";
    private static final String databaseName = "client_schedule";
    private static final String url = protocol + vendor + location + databaseName + "?connectionTimeZone=SERVER";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String userName = "sqlUser";
    private static final String password = "Passw0rd!";

    /**
     * A Connection to use for database connection operations.
     */
    public static Connection connection;

    /**
     * Opens a connection to the database.
     */
    public static void OpenConnection() throws SQLException {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException ex) {
            System.out.println("Could not connect to database: " + ex.getMessage());
            throw new SQLException(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Could not find the class for the driver.");
            throw new SQLException(ex);
        }
    }

    /**
     * Closes a connection to the database.
     */
    public static void CloseConnection() {
        try {
            connection.close();
        } catch (Exception ex) {
            System.out.println("Could not close connection: " + ex.getMessage());
        }
    }
}
