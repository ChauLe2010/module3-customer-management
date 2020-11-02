package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService {
    static Map<Integer,Customer> customers;
    static {
        customers=new HashMap<>();
        customers.put(1,new Customer(1,"Chi","Ha Noi"));
        customers.put(2,new Customer(2,"Huyen","Ha Noi"));
        customers.put(3,new Customer(3,"Son","Ha Noi"));
        customers.put(4,new Customer(4,"Hoang","Ha Noi"));
        customers.put(5,new Customer(5,"THanh","Ha Noi"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }
}
