package softwaretwo.data.repositories;

import softwaretwo.data.access.ClientScheduleContext;
import softwaretwo.data.models.Appointment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

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
        } finally {
            ClientScheduleContext.CloseConnection();
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
    public boolean insert(Appointment appointment) {
        final String sql = """
                    INSERT INTO client_schedule.appointments (Title, Description, Location, Type, Start, End, Create_Date, Created_By, Last_Update, Last_Updated_By, Customer_ID, User_ID, Contact_ID)
                    VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);
                """;
        try {
            ClientScheduleContext.OpenConnection();
            Timestamp createDate = Timestamp.from(Instant.now());
            PreparedStatement ps = ClientScheduleContext.connection.prepareStatement(sql);
            ps.setString(1, appointment.getTitle());
            ps.setString(2, appointment.getDescription());
            ps.setString(3, appointment.getLocation());
            ps.setString(4, appointment.getType());
            ps.setTimestamp(5, Timestamp.from(Instant.from(appointment.getStart())));
            ps.setTimestamp(6, Timestamp.from(Instant.from(appointment.getEnd())));
            ps.setTimestamp(7, createDate);
            ps.setString(8, appointment.getCreatedBy());
            ps.setTimestamp(9, createDate);
            ps.setString(10, appointment.getLastUpdatedBy());
            ps.setInt(11, appointment.getCustomerId());
            ps.setInt(12, appointment.getUserId());
            ps.setInt(13, appointment.getContactId());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Failed to insert appointment with SQL. Reason: " + ex.getMessage());
            return false;
        } catch (Exception ex) {
            System.out.println("Failed to insert appointment error: " + ex.getMessage());
            return false;
        } finally {
            ClientScheduleContext.CloseConnection();
        }
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
        final String deleteSql = "DELETE FROM appointments WHERE Appointment_ID=?";
        try {
            ClientScheduleContext.OpenConnection();
            PreparedStatement ps = ClientScheduleContext.connection.prepareStatement(deleteSql);
            ps.setInt(1, appointmentId);
            ps.execute();
        } catch (Exception ex) {
            System.out.println("Could not delete appointment, reason: " + ex.getMessage());
        }
    }

    public Appointment getAppointmentByTitle(String title) {
        final String getByTitleSql = "SELECT * FROM appointments WHERE Title=? LIMIT 1";
        try {
            ClientScheduleContext.OpenConnection();
            PreparedStatement ps = ClientScheduleContext.connection.prepareStatement(getByTitleSql);
            ps.setString(1, title);
            ResultSet results = ps.executeQuery();

            Appointment newAppointment = new Appointment();
            while (results.next()) {
                newAppointment.setId(results.getInt(1));
                newAppointment.setTitle(results.getString(2));
                newAppointment.setDescription(results.getString(3));
                newAppointment.setLocation(results.getString(4));
                newAppointment.setType(results.getString(5));
                newAppointment.setCreatedBy(results.getString(9));
                newAppointment.setLastUpdatedBy(results.getString(11));

                // manage the date times -- TODO specify timezone of logged in user vs UTC.
                TimeZone tz = TimeZone.getDefault();
                Timestamp startTime = results.getTimestamp(6);
                newAppointment.setStart(startTime.toInstant().atZone(ZoneId.of("UTC")));

                Timestamp endTime = results.getTimestamp(7);
                newAppointment.setEnd(endTime.toInstant().atZone(ZoneId.of("UTC")));

                Timestamp createdDate = results.getTimestamp(8);
                newAppointment.setCreateDate(createdDate.toInstant().atZone(ZoneId.of("UTC")));

                Timestamp lastUpdated = results.getTimestamp(10);
                newAppointment.setLastUpdate(lastUpdated.toInstant().atZone(ZoneId.of("UTC")));
            }

            return newAppointment;
        } catch (Exception ex) {
            System.out.println("Could not get appointment, reason: " + ex.getMessage());
            return null;
        }
    }
}
