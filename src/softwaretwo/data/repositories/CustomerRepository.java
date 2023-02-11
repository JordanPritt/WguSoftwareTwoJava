package softwaretwo.data.repositories;

import softwaretwo.data.models.Customer;

import java.util.List;

/**
 * A repository for Customer database interactions.
 */
public class CustomerRepository implements ICustomerRepository {
    /**
     * @inheritDocs
     */
    @Override
    public boolean deleteCustomer(int customerId) {
        return false;
    }

    /**
     * @inheritDocs
     */
    @Override
    public boolean insertCustomer(Customer customer) {
        return false;
    }

    /**
     * @inheritDocs
     */
    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    /**
     * @inheritDocs
     */
    @Override
    public Customer getUser(int id) {
        return null;
    }
}
