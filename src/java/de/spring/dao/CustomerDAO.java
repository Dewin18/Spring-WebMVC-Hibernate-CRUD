package de.spring.dao;

import de.spring.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    Customer getCustomer(int id);

    void addCustomer(Customer customer);

    void deleteCustomer(int id);

    void updateCustomer(Customer customer);
}
