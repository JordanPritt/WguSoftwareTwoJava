package softwaretwo.data.repositories;

import softwaretwo.data.models.Appointment;

import java.util.List;

/**
 * An interface for a repository for Appointment database interactions.
 */
public interface IAppointmentRepository {
    /**
     * Retrieves all appointments from the database.
     * @return list of appointments.
     */
    List<Appointment> getAllAppointments();

    /**
     * Retrieves an appointment by its identifier.
     * @param appointmentId a appointment's identifier.
     * @return an appointment object.
     */
    Appointment getAppointment(int appointmentId);

    /**
     * Inserts a new appointment to the database;
     * @param appointment an appointment to insert.
     * @return a boolean representing pass or fail.
     */
    boolean insertAppointment(Appointment appointment);

    /**
     * Updates an existing appointment in the database.
     * @param appointment an appointment to update.
     * @return a boolean to represent pass or fail.
     */
    boolean updateAppointment(Appointment appointment);

    /**
     * Delete an existing appointment.
     * @param appointmentId an appointment's identifier.
     * @return a boolean representing pass or fail.
     */
    boolean deleteAppointment(int appointmentId);
}
