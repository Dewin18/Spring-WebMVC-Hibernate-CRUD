package de.spring.dao;

import de.spring.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Customer> getCustomers() {

        Session currentSession = factory.getCurrentSession();
        Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);
        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public Customer getCustomer(int id) {
        Session currentSession = factory.getCurrentSession();
        Customer customer = currentSession.get(Customer.class, id);
        return customer;
    }

    @Override
    public void addCustomer(Customer customer) {
        Session currentSession = factory.getCurrentSession();
        currentSession.save(customer);
    }

    @Override
    public void updateCustomer(Customer newCustomer) {

        Session currentSession = factory.getCurrentSession();
        Customer oldCustomer = currentSession.get(Customer.class, newCustomer.getId());

        oldCustomer.setFirstName(newCustomer.getFirstName());
        oldCustomer.setLastName(newCustomer.getLastName());
        oldCustomer.setEmail(newCustomer.getEmail());
    }

    @Override
    public void deleteCustomer(int id) {
        Session currentSession = factory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Customer where id =: customerId");
        query.setParameter("customerId", id);
        query.executeUpdate();
    }
}
