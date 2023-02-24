package CustomerMS.Service;


import CustomerMS.Entity.Customer;
import CustomerMS.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceimpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public Customer save(Customer customer)
    {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> fetchCustomersList() {
        return (List<Customer>)
                customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer updateCustomer(Customer customer, int id) {
        customerRepository.save(customer);
        return customer;
    }
    @Override
    public void deleteCustomer(int id) {

        customerRepository.deleteById(id);
    }
}



