package de.spring.services;

import de.spring.entity.User;
import org.springframework.stereotype.Component;

public interface UserCRUDServiceIF {

    void saveUser(User user);

    void deleteUser(User user);

    void deleteUserById(int id);

    void updateFirstNameById(int id, String newFirstName);

    void updateLastNameById(int id, String newLastName);

    void updateUserNameById(int id, String newFirstName, String newLastName);

    void updateUserById(int id, String newFirstName, String newLastName, String newEmail);
}
