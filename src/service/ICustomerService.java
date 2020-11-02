package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
}
