package softwaretwo.data.repositories;

import softwaretwo.data.access.ClientScheduleContext;
import softwaretwo.data.models.Appointment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A repository for Appointment database interactions.
 */
public class AppointmentRepository implements IAppointmentRepository {
    /**
     * @inheritDoc
     */
    @Override
    public List<Appointment> getAllAppointments() {
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
                newAppointment.setStart(results.getDate(6));
                newAppointment.setEnd(results.getDate(7));
                newAppointment.setCreateDate(results.getDate(8));
                newAppointment.setCreatedBy(results.getString(9));
                newAppointment.setLastUpdate(results.getDate(10));
                newAppointment.setLastUpdatedBy(results.getString(11));
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
    @Override
    public Appointment getAppointment(int appointmentId) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean insertAppointment(Appointment appointment) {
        return false;
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean updateAppointment(Appointment appointment) {
        return false;
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean deleteAppointment(int appointmentId) {
        return false;
    }
}
