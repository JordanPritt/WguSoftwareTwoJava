package softwaretwo.services;

import softwaretwo.data.models.Appointment;
import softwaretwo.data.repositories.AppointmentRepository;
import softwaretwo.data.repositories.IAppointmentRepository;

import java.util.List;

/**
 * A service for managing appointments.
 */
public class AppointmentService {
    private final IAppointmentRepository appointmentRepo = new AppointmentRepository();

    /**
     * Empty constructor.
     */
    public void Appointment() {
    }

    /**
     * Retrieves all appointments.
     *
     * @return a list of appointments.
     */
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.getAllAppointments();
    }
}
