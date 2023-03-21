package softwaretwo.data.repositories;

import softwaretwo.data.access.ClientScheduleContext;
import softwaretwo.data.models.Appointment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * A repository for Appointment database interactions.
 */
public class AppointmentRepository {
    /**
     * @inheritDoc
     */
    public List<Appointment> getAll() {
        try {
            ClientScheduleContext.OpenConnection();
            List<Appointment> appointments = new ArrayList<>();

            String getAllSql = """
                    SELECT * FROM client_schedule.Appointments;
                    """;

            PreparedStatement ps = ClientScheduleContext.connection.prepareStatement(getAllSql);
            ResultSet results = ps.executeQuery();

            while (results.next()) {
                Appointment newAppointment = new Appointment();
                newAppointment.setId(results.getInt(1));
                newAppointment.setTitle(results.getString(2));
                newAppointment.setDescription(results.getString(3));
                newAppointment.setLocation(results.getString(4));
                newAppointment.setType(results.getString(5));
                newAppointment.setCreatedBy(results.getString(9));
                newAppointment.setLastUpdatedBy(results.getString(11));

                // manage the date times -- TODO specify timezone of logged in user vs UTC.
                Timestamp startTime = results.getTimestamp(6);
                newAppointment.setStart(startTime.toLocalDateTime().atZone(ZoneId.of("UTC")));

                Timestamp endTime = results.getTimestamp(7);
                newAppointment.setEnd(endTime.toLocalDateTime().atZone(ZoneId.of(("UTC"))));

                Timestamp createdDate = results.getTimestamp(8);
                newAppointment.setCreateDate(createdDate.toLocalDateTime().atZone(ZoneId.of(("UTC"))));

                Timestamp lastUpdated = results.getTimestamp(10);
                newAppointment.setLastUpdate(lastUpdated.toLocalDateTime().atZone(ZoneId.of(("UTC"))));

                appointments.add(newAppointment);
            }

            return appointments;
        } catch (SQLException ex) {
            System.out.println("Failed to query Appointments data. Reason: " + ex.getMessage());
            return new ArrayList<>();
        } catch (Exception ex) {
            System.out.println("Get All Appointments error: " + ex.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * @inheritDoc
     */
    public Appointment get(int appointmentId) {
        return null;
    }

    /**
     * @inheritDoc
     */
    public void insert(Appointment appointment) {

    }

    /**
     * @inheritDoc
     */
    public void update(Appointment appointment) {

    }

    /**
     * @inheritDoc
     */
    public void delete(int appointmentId) {

    }
}
