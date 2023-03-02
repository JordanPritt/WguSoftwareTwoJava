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
public class FirstLevelDomainRepository implements IFirstLevelDomainRepository {
    /**
     * @inheritDocs
     */
    @Override
    public List<FirstLevelDomain> getDomains() {
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
}
