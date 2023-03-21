package softwaretwo.data.repositories;

import softwaretwo.data.access.ClientScheduleContext;
import softwaretwo.data.models.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class CountriesRepository {
    /**
     * @inheritDocs
     */
    public List<Country> getAllCountries() {
        final String sql = """
                SELECT * FROM client_schedule.countries;
                """;
        try {
            ClientScheduleContext.OpenConnection();
            PreparedStatement ps = ClientScheduleContext.connection.prepareStatement(sql);
            ResultSet results = ps.executeQuery();
            ArrayList<Country> countries = new ArrayList<>();

            while (results.next()) {
                // manage timestamps
                Timestamp createdDate = results.getTimestamp(3);
                Timestamp updatedDate = results.getTimestamp(5);
                // add country to list
                countries.add(new Country(results.getInt(1),
                        results.getString(2),
                        createdDate.toLocalDateTime().atZone(ZoneId.of("UTC")),
                        results.getString(4),
                        updatedDate.toLocalDateTime().atZone(ZoneId.of("UTC")),
                        results.getString(6)));
            }
            return countries;
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
            return new ArrayList<>();
        } finally {
            ClientScheduleContext.CloseConnection();
        }
    }
}
