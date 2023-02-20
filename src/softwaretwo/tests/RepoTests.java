package softwaretwo.tests;

import softwaretwo.data.models.Appointment;
import softwaretwo.data.models.Customer;
import softwaretwo.data.models.User;
import softwaretwo.data.repositories.*;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
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
        try {
            IUserRepository userRepo = new UserRepo();
            User user = userRepo.getSignInUser("test", "test");
            return user.getUserId() == 1;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Tests the get all appointments, method.
     *
     * @return a boolean representing pass or fail.
     */
    public static boolean getAllAppointmentsTest() {
        try {
            IAppointmentRepository apptRepo = new AppointmentRepository();
            List<Appointment> appointments = apptRepo.getAllAppointments();
            return appointments.size() > 0;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Tests inserting a customer.
     *
     * @return a boolean representing pass or fail.
     */
    public static boolean insertCustomerTest() {
        try {
            // guarantee created date and updated date are the same
            java.sql.Date date = new java.sql.Date(Date.from(Instant.now()).getTime());
            // setup mock data
            ICustomerRepository customerRepo = new CustomerRepository();
            Customer mockCustomer = new Customer();
            mockCustomer.setCustomerName("Server Generated");
            mockCustomer.setAddress("123 Test Road, Citiesburgh");
            mockCustomer.setPostalCode("12345");
            mockCustomer.setPhone("+1 (123)-456-7890");
            mockCustomer.setCreatedDate(date);
            mockCustomer.setCreatedBy("Server");
            mockCustomer.setLastUpdate(date);
            mockCustomer.setLastUpdatedBy("Server");
            mockCustomer.setDivisionId(37);
            // run insert and return the result
            return customerRepo.insertCustomer(mockCustomer);
        } catch (Exception ex) {
            //System.out.println("Error: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Tests deleting a customer.
     *
     * @return a boolean representing pass or fail.
     */
    public static boolean deleteCustomerTest() {
        try {
            ICustomerRepository customerRepo = new CustomerRepository();
            return customerRepo.deleteCustomer("Server Generated");
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * Tests updating a customer.
     *
     * @return a boolean representing pass or fail
     */
    public static boolean updateCustomerTest() {
        try {
            ICustomerRepository customerRepo = new CustomerRepository();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date createdDate = formatter.parse("2023-02-05 23:48:30");
            Date lastUpdatedDate = formatter.parse("2023-02-05 23:48:30");

            Customer mockData = new Customer("Daddy Warbucks", "1919 Boardwalk", "01291",
                    "869-908-1875", createdDate, "script", lastUpdatedDate, "server",
                    29, 1);
            return customerRepo.updateCustomer(mockData);
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean getAllCustomerTest() {
        try {
            ICustomerRepository customerRepo = new CustomerRepository();
            List<Customer> customers = customerRepo.getAllCustomers();
            if (customers.size() > 0)
                return true;
            else
                throw new Exception("No customers in database, check for missing data.");
        } catch (Exception ex) {
            System.out.println("Test failed, reason: " + ex.getMessage());
            return false;
        }
    }
}
