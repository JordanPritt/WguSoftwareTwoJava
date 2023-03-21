package softwaretwo.tests;

import softwaretwo.data.models.Appointment;
import softwaretwo.data.models.Customer;
import softwaretwo.data.models.User;
import softwaretwo.data.repositories.*;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
            UserRepository userRepository = new UserRepository();
            User user = userRepository.getSignInUser("test", "test");
            return user.getUserId() == 1;
        } catch (Exception ex) {
            printTestError(ex.getMessage());
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
            AppointmentRepository apptRepo = new AppointmentRepository();
            List<Appointment> appointments = apptRepo.getAll();
            return appointments.size() > 0;
        } catch (Exception ex) {
            printTestError(ex.getMessage());
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
            ZonedDateTime date = ZonedDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
            // setup mock data
            CustomerRepository customerRepo = new CustomerRepository();
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
            return customerRepo.insert(mockCustomer);
        } catch (Exception ex) {
            printTestError(ex.getMessage());
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
            CustomerRepository customerRepo = new CustomerRepository();
            return customerRepo.delete("Server Generated");
        } catch (Exception ex) {
            printTestError(ex.getMessage());
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
            CustomerRepository customerRepo = new CustomerRepository();
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("UTC"));
            ZonedDateTime createdDate = ZonedDateTime.parse("2023-02-05 23:48:30", formatter);
            ZonedDateTime lastUpdatedDate = ZonedDateTime.parse("2023-02-05 23:48:30", formatter);

            Customer mockData = new Customer("Daddy Warbucks", "1919 Boardwalk", "01291",
                    "869-908-1875", createdDate, "script", lastUpdatedDate, "server",
                    29, 1);
            return customerRepo.update(mockData);
        } catch (Exception ex) {
            printTestError(ex.getMessage());
            return false;
        }
    }

    /**
     * Tests gettings a list of all the customers.
     *
     * @return a boolean indicating pass or fail.
     */
    public static boolean getAllCustomerTest() {
        try {
            CustomerRepository customerRepo = new CustomerRepository();
            List<Customer> customers = customerRepo.getAll();
            if (customers.size() > 0)
                return true;
            else
                throw new Exception("No customers in database, check for missing data.");
        } catch (Exception ex) {
            printTestError(ex.getMessage());
            return false;
        }
    }

    /**
     * Tests getting a customer by their identifier.
     *
     * @return a boolean representing pass or fail.
     */
    public static boolean getCustomerTest() {
        try {
            CustomerRepository customerRepo = new CustomerRepository();
            Customer customer = customerRepo.get(1);
            if (customer.getCustomerName().equals("Daddy Warbucks"))
                return true;
            else
                throw new Exception("Customer was not found.");
        } catch (Exception ex) {
            printTestError(ex.getMessage());
            return false;
        }
    }

    public static boolean getDivisionByNameTest() {
        try {
            FirstLevelDomainRepository firstLevelDomainRepo = new FirstLevelDomainRepository();
            int domainId = firstLevelDomainRepo.getByName("Alabama");
            if (domainId != 1)
                throw new Exception("Wrong domain Id was returned.");
            else
                return true;
        } catch (Exception ex) {
            printTestError(ex.getMessage());
            return false;
        }
    }

    // help method for printing out error messages.
    private static void printTestError(String errorMessage) {
        System.out.println("Test failed, reason: " + errorMessage);
    }
}
