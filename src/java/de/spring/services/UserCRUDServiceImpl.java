package de.spring.services;

import de.spring.entity.User;
import de.spring.util.SessionFactoryIF;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCRUDServiceImpl implements UserCRUDServiceIF {

    @Autowired
    private SessionFactoryIF sessionFactory;


    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public void updateFirstNameById(int id, String newFirstName) {

    }

    @Override
    public void updateLastNameById(int id, String newLastName) {

    }

    @Override
    public void updateUserNameById(int id, String newFirstName, String newLastName) {

    }

    @Override
    public void updateUserById(int id, String newFirstName, String newLastName, String newEmail) {

    }
}
