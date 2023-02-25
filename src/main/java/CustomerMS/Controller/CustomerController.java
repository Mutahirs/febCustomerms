package CustomerMS.Controller;

import CustomerMS.Entity.Customer;
import CustomerMS.MicroserviceApplication;
import CustomerMS.Repository.CustomerRepository;
import CustomerMS.Service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

    static Logger logger= LogManager.getLogger(MicroserviceApplication.class);

    @Autowired
    CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    //TO add new Customers
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customerMS)
    {
        logger.info("Adding customer to list");
        return customerService.save(customerMS);
    }

    // To get list of all customers
    @GetMapping("/getCustomerDetails")
    public List<Customer> getCustomerList()
    {
        logger.info("Displaying all the customers");
        return customerService.fetchCustomersList();
    }

    //searching customer by id
    @GetMapping("/customer/{id}")
    private Customer getCustomers(@PathVariable("id") int id)
    {
        logger.info("Displaying a specific customers");
        return customerService.getCustomerById(id);
    }

    // Updating the customer details
    @PutMapping("/updateCustomer/{id}")
    public Customer updateCustomer(@RequestBody Customer customer,
                                    @PathVariable("id") int id)
    {
        logger.info("Updating the customer details");
        return customerService.updateCustomer(
                customer, id);
    }

    // Deleting a customer
    @DeleteMapping("deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id")
                                 int id)
    {
        logger.info("Deleting the customer details");
        customerService.deleteCustomer(id);
        return "Deleted Successfully";
    }

    // searching customer by name
    @GetMapping("/Customer/{name}")
    public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable String name) {
        logger.info("Searching customer by name");
        return new ResponseEntity<List<Customer>>(customerRepository.findByName(name), HttpStatus.OK);
    }

}
