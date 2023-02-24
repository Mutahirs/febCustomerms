package CustomerMS.Controller;

import CustomerMS.Entity.Customer;
import CustomerMS.Repository.CustomerRepository;
import CustomerMS.Service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    //TO add new Customers
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customerMS)
    {
        return customerService.save(customerMS);
    }

    // To get list of all customers
    @GetMapping("/getCustomerDetails")
    public List<Customer> getCustomerList()
    {
        return customerService.fetchCustomersList();
    }

    @GetMapping("/customer/{id}")
    private Customer getCustomers(@PathVariable("id") int id)
    {
        return customerService.getCustomerById(id);
    }

    // Update Operation
    @PutMapping("/updateCustomer/{id}")
    public Customer updateCustomer(@RequestBody Customer customer,
                                    @PathVariable("id") int id)
    {
        return customerService.updateCustomer(
                customer, id);
    }

    // Deleting a customer
    @DeleteMapping("deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id")
                                 int id)
    {
        customerService.deleteCustomer(id);
        return "Deleted Successfully";
    }

    // searching customer by name
    @GetMapping("/Customer/{name}")
    public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable String name) {
        return new ResponseEntity<List<Customer>>(customerRepository.findByName(name), HttpStatus.OK);
    }

}
