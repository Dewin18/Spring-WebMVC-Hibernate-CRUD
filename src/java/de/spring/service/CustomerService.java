package de.spring.service;

import de.spring.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    Customer getCustomer(int customerId);

    void addCustomer(Customer customer);

    void deleteCustomer(int id);

    void updateCustomer(Customer customer);
}
