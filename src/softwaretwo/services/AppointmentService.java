package softwaretwo.services;

import softwaretwo.data.models.Appointment;
import softwaretwo.data.repositories.AppointmentRepository;
import softwaretwo.data.repositories.IAppointmentRepository;

import java.util.List;

/**
 * A service for managing appointments.
 */
public class AppointmentService implements ICrudService<Appointment> {
    private final IAppointmentRepository appointmentRepo = new AppointmentRepository();

    /**
     * Retrieves an appointment by id.
     *
     * @return an appointment.
     * @throws Exception with message of what failed.
     */
    @Override
    public Appointment get(int id) throws Exception {
        try {
            return appointmentRepo.getAppointment(id);
        } catch (Exception ex) {
            throw new Exception("Could not get appointment: " + ex.getMessage());
        }
    }

    /**
     * Retrieves a list of all appointments.
     *
     * @return A list of Appointments.
     * @throws Exception with message of what failed.
     */
    @Override
    public List<Appointment> getAll() throws Exception {
        try {
            return appointmentRepo.getAllAppointments();
        } catch (Exception ex) {
            throw new Exception("Could not get appointments: " + ex.getMessage());
        }
    }

    /**
     * @param appointment the T to create.
     * @throws Exception with message of what failed.
     */
    @Override
    public void create(Appointment appointment) throws Exception {
        try {
            appointmentRepo.insertAppointment(appointment);
        } catch (Exception ex) {
            throw new Exception("Could not create appointment: " + ex.getMessage());
        }
    }

    /**
     * @param appointment the T to update.
     * @throws Exception with message of what failed.
     */
    @Override
    public void update(Appointment appointment) throws Exception {
        try {
            appointmentRepo.updateAppointment(appointment);
        } catch (Exception ex) {
            throw new Exception("Could not update appointment: " + ex.getMessage());
        }
    }

    /**
     * @param appointment the T to delete.
     * @throws Exception with message of what failed.
     */
    @Override
    public void delete(Appointment appointment) throws Exception {
        try {
            appointmentRepo.deleteAppointment(appointment.getId());
        } catch (Exception ex) {
            throw new Exception("Could not delete appointment: " + ex.getMessage());
        }
    }
}
