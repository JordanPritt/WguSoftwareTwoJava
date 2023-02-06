package data.repositories;

import com.mysql.cj.result.Field;
import data.access.ClientScheduleContext;
import data.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepo implements IUserRepository {
    @Override
    public User getSignInUser(String userName, String password) {
        String sql = """
                SELECT * FROM User WHERE User_Name=? AND Password=?;
                """;
        try {
            ClientScheduleContext.OpenConnection();
            User user = null;

            PreparedStatement ps = ClientScheduleContext.connection.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                user.setUserId(results.getInt(1));
                //user.setLastUpdate();
            }
            return user;
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
            return null;
        } finally {
            ClientScheduleContext.CloseConnection();
        }
    }
}
