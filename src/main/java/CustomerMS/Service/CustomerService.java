package CustomerMS.Service;

import CustomerMS.Entity.Customer;
import org.elasticsearch.client.ElasticsearchClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CustomerService {

    @Autowired
     public ElasticsearchClient elasticsearchClient = null;

    Customer save(Customer customerMS);

    List<Customer> fetchCustomersList();

    Customer getCustomerById(int id);

    abstract Customer updateCustomer(Customer customerMS, int id);

    void deleteCustomer(int id);


}

