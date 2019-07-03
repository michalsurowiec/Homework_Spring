package beans.interfaces;

import beans.model.Customer;

import java.util.List;

public interface CustomerRepository {

    void add(Customer customer);

    List<Customer> readAll();

    void delete(int id);

}
