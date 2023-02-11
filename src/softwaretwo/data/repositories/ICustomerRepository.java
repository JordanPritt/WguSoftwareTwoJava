package softwaretwo.data.repositories;

import softwaretwo.data.models.Customer;

import java.util.List;

/**
 * An interface for a repository for Customer database interactions.
 */
public interface ICustomerRepository {
    /**
     * Deletes a user from the database based on an id.
     *
     * @param customerId a user's identifier.
     * @return boolean indicating pass or fail.
     */
    boolean deleteCustomer(int customerId);

    /**
     * Inserts a new user to the database.
     *
     * @param customer the User to be inserted.
     * @return a boolean indicating pass or fail.
     */
    boolean insertCustomer(Customer customer);

    /**
     * Retrieves all users from the database.
     *
     * @return a list of all users.
     */
    List<Customer> getAllCustomers();

    /**
     * Retrieve a customer by their identifier.
     *
     * @param id a customer's identifier.
     * @return a customer object.
     */
    Customer getUser(int id);
}
