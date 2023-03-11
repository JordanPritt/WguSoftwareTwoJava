package softwaretwo.services;

import softwaretwo.data.models.Customer;
import softwaretwo.data.repositories.CustomerRepository;
import softwaretwo.data.repositories.ICustomerRepository;

import java.util.List;

/**
 * Service class for managing customers.
 */
public class CustomerService implements ICrudService<Customer> {
    private final ICustomerRepository customerRepo = new CustomerRepository();

    /**
     * Gets a customer by id.
     *
     * @param id the id used to retrieve a Customer by.
     * @return a Customer object.
     */
    @Override
    public Customer get(int id) throws Exception {
        try {
            return customerRepo.getCustomer(id);
        } catch (Exception ex) {
            String message = "Could not get customer with id:" + Integer.toString(id) + " reason: " + ex.getMessage();
            throw new Exception(message);
        }
    }

    /**
     * Gets a list of Customers.
     *
     * @return a list of all Customers.
     */
    @Override
    public List<Customer> getAll() {
        return customerRepo.getAllCustomers();
    }

    /**
     * Creates a new Customer.
     *
     * @param customer the customer to create.
     * @throws Exception the exception caught.
     */
    @Override
    public void create(Customer customer) throws Exception {
        try {
            customerRepo.insertCustomer(customer);
        } catch (Exception ex) {
            String message = "Could not save customer:" + customer.getCustomerName() + " because:" + ex.getMessage();
            System.out.println("Could not save customer: " + ex.getMessage());
            throw new Exception(message);
        }
    }

    @Override
    public void update(Customer customer) throws Exception {
        try {
            customerRepo.updateCustomer(customer);
        } catch (Exception ex) {
            String message = "Could not update customer: " + ex.getMessage();
            System.out.println(message);
            throw new Exception(message);
        }
    }

    @Override
    public void delete(Customer customer) throws Exception {
        try {
            customerRepo.deleteCustomer(customer.getCustomerId());
        } catch (Exception ex) {
            String message = "Could not delete customer: " + ex.getMessage();
            System.out.println(message);
            throw new Exception(message);
        }
    }

}
