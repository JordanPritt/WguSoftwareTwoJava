package softwaretwo.data.repositories;

import softwaretwo.data.access.ClientScheduleContext;
import softwaretwo.data.models.FirstLevelDomain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for First Level Domains.
 */
public class FirstLevelDomainRepository {
    /**
     * @inheritDocs
     */
    public List<FirstLevelDomain> getAll() {
        final String sql = """
                SELECT Division_ID, Division, COUNTRY_ID
                FROM client_schedule.first_level_divisions
                """;
        try {
            ClientScheduleContext.OpenConnection();
            PreparedStatement ps = ClientScheduleContext.connection.prepareStatement(sql);
            ResultSet results = ps.executeQuery();
            ArrayList<FirstLevelDomain> domains = new ArrayList<>();

            while (results.next()) {
                domains.add(new FirstLevelDomain(results.getInt(1),
                        results.getString(2),
                        results.getInt(3)));
            }

            return domains;
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
            return new ArrayList<>();
        } finally {
            ClientScheduleContext.CloseConnection();
        }
    }

    public int getByName(String divisionName) throws Exception {
        final String sql = """
                SELECT Division_ID
                FROM client_schedule.first_level_divisions
                WHERE Division = ?
                """;
        try {
            ClientScheduleContext.OpenConnection();
            PreparedStatement ps = ClientScheduleContext.connection.prepareStatement(sql);
            ps.setString(1, divisionName);
            ResultSet results = ps.executeQuery();
            int divisionId = -1;
            while (results.next()) {
                divisionId = results.getInt("Division_ID");
            }

            if (divisionId != -1)
                return divisionId;

            throw new Exception("Could not find division id for: " + divisionName);
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
            throw new Exception(ex.getMessage());
        } finally {
            ClientScheduleContext.CloseConnection();
        }
    }
}
