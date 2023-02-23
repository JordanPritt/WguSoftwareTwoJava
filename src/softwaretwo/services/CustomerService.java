package softwaretwo.services;

import softwaretwo.data.models.Customer;
import softwaretwo.data.repositories.CustomerRepository;
import softwaretwo.data.repositories.ICustomerRepository;

import java.util.List;

/**
 * Service class for managing customers.
 */
public class CustomerService {
    final private ICustomerRepository customerRepo = new CustomerRepository();

    public List<Customer> getCustomers() {
        return customerRepo.getAllCustomers();
    }
}
