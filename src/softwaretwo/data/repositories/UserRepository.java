package softwaretwo.data.repositories;

import softwaretwo.data.access.ClientScheduleContext;
import softwaretwo.data.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A repository for User database interactions.
 */
public class UserRepository {
    /**
     * @inheritDoc
     */
    public User getSignInUser(String userName, String password) {
        String sql = """
                SELECT * FROM client_schedule.users WHERE User_Name=? AND Password=? LIMIT 1;
                """;
        try {
            ClientScheduleContext.OpenConnection();
            User user = new User();

            PreparedStatement ps = ClientScheduleContext.connection.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet results = ps.executeQuery();

            while (results.next()) {
                user.setUserId(results.getInt(1));
                user.setUserName(results.getString(2));
                user.setPassword(results.getString(3));
                user.setCreateDate(results.getDate(4));
                user.setCreateBy(results.getString(5));
                user.setLastUpdate(results.getDate(6));
                user.setLastUpdatedBy(results.getString(7));
            }

            if (user.getUserName() == null)
                throw new SQLException("Could not sign-in user: " + userName);

            return user;
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
            return null;
        } finally {
            ClientScheduleContext.CloseConnection();
        }
    }

    /**
     * @inheritDoc
     */
    public User getUser(int userId) {
        return null;
    }

    /**
     * @inheritDoc
     */
    public boolean insertUser(User user) {
        return false;
    }

    /**
     * @inheritDoc
     */
    public boolean updateUser(User user) {
        return false;
    }

    /**
     * @inheritDoc
     */
    public boolean deleteUser(int userId) {
        return false;
    }
}
