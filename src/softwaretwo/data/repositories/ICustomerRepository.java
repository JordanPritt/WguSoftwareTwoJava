package softwaretwo.data.repositories;

import softwaretwo.data.models.Customer;

import java.util.List;

/**
 * An interface for a repository for Customer database interactions.
 */
public interface ICustomerRepository {
    /**
     * Deletes a customer from the database based on an id.
     *
     * @param customerId a customer's identifier.
     * @return boolean indicating pass or fail.
     */
    boolean deleteCustomer(int customerId);

    /**
     * Updates a customer in the database.
     *
     * @param customer the Customer to be inserted.
     * @return a boolean indicating pass or fail.
     */
    boolean updateCustomer(Customer customer);

    /**
     * Deletes a customer from the database based on name.
     *
     * @param customerName a customer's name.
     * @return boolean indicating pass or fail.
     */
    boolean deleteCustomer(String customerName);

    /**
     * Inserts a new customer to the database.
     *
     * @param customer the Customer to be inserted.
     * @return a boolean indicating pass or fail.
     */
    boolean insertCustomer(Customer customer);

    /**
     * Retrieves all customers from the database.
     *
     * @return a list of all customers.
     */
    List<Customer> getAllCustomers();

    /**
     * Retrieve a customer by their identifier.
     *
     * @param id a customer's identifier.
     * @return a customer object.
     */
    Customer getCustomer(int id);
}
