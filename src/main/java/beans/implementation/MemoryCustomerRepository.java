package beans.implementation;

import beans.interfaces.CustomerLogger;
import beans.interfaces.CustomerRepository;
import beans.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryCustomerRepository implements CustomerRepository {
    private List<Customer> customerList = new ArrayList<>();
    private CustomerLogger customerLogger;


    public MemoryCustomerRepository(CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
    }

    @Override
    public void add(Customer customer) {
        customerLogger.log();
        this.customerList.add(customer);
    }

    @Override
    public List<Customer> readAll() {
        customerLogger.log();
        return this.customerList;
    }

    @Override
    public void delete(int id) {
        customerLogger.log();
        this.customerList.remove(id);
    }
}
