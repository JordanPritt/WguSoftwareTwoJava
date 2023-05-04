package softwaretwo.services;

import softwaretwo.data.models.Appointment;
import softwaretwo.data.repositories.AppointmentRepository;

import java.util.List;

/**
 * A service for managing appointments.
 */
public class AppointmentService implements ICrudService<Appointment> {
    private final AppointmentRepository appointmentRepo = new AppointmentRepository();

    /**
     * Retrieves an appointment by id.
     *
     * @return an appointment.
     * @throws Exception with message of what failed.
     */
    @Override
    public Appointment get(int id) throws Exception {
        try {
            return appointmentRepo.get(id);
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
            return appointmentRepo.getAll();
        } catch (Exception ex) {
            throw new Exception("Could not get appointments: " + ex.getMessage());
        }
    }

    /**
     * @param appointment the T to create.
     * @throws Exception with message of what failed.
     */
    @Override
    public boolean create(Appointment appointment) throws Exception {
        try {
            boolean result = appointmentRepo.insert(appointment);
            return result;
        } catch (Exception ex) {
            throw new Exception("Could not create appointment: " + ex.getMessage());
        }
    }

    /**
     * @param appointment the T to update.
     * @throws Exception with message of what failed.
     */
    @Override
    public boolean update(Appointment appointment) throws Exception {
        try {
            appointmentRepo.update(appointment);
            return true;
        } catch (Exception ex) {
            throw new Exception("Could not update appointment: " + ex.getMessage());
        }
    }

    /**
     * @param appointment the T to delete.
     * @throws Exception with message of what failed.
     */
    @Override
    public boolean delete(Appointment appointment) throws Exception {
        try {
            appointmentRepo.delete(appointment.getId());
            return true;
        } catch (Exception ex) {
            throw new Exception("Could not delete appointment: " + ex.getMessage());
        }
    }
}
