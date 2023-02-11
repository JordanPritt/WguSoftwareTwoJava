package softwaretwo.tests;

import softwaretwo.data.models.Appointment;
import softwaretwo.data.models.User;
import softwaretwo.data.repositories.AppointmentRepository;
import softwaretwo.data.repositories.IAppointmentRepository;
import softwaretwo.data.repositories.IUserRepository;
import softwaretwo.data.repositories.UserRepo;

import java.util.List;

/**
 * Repository tests.
 */
public class RepoTests {
    /**
     * Tests the sign-in method.
     *
     * @return a boolean representing pass or fail.
     */
    public static boolean getSignInUserTest() {
        IUserRepository userRepo = new UserRepo();
        User user = userRepo.getSignInUser("test", "test");
        return user.getUserId() == 1;
    }

    /**
     * Tests the get all appointments method.
     *
     * @return a boolean representing pass or fail.
     */
    public static boolean getAllAppointmentsTest() {
        IAppointmentRepository apptRepo = new AppointmentRepository();
        List<Appointment> appointments = apptRepo.getAllAppointments();
        return appointments.size() > 0;
    }
}
