package de.spring.entity;
import de.spring.util.ErrorMsg;
import de.spring.util.RegexPattern;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="customer")
public class Customer {

    public Customer() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment as it is defined in the table
    @Column(name="id")
    private int id;

    @Pattern(regexp = RegexPattern.NAME_REGEX, message = ErrorMsg.NAME_INVALID)
    @Size(max = 20, message = ErrorMsg.LONG_NAME)
    @Column(name="first_name")
    private String firstName;

    @Pattern(regexp = RegexPattern.NAME_REGEX, message = ErrorMsg.NAME_INVALID)
    @Size(max = 20, message = ErrorMsg.LONG_NAME)
    @Column(name="last_name")
    private String lastName;

    @Pattern(regexp = RegexPattern.EMAIL_REGEX, message = ErrorMsg.EMAIL_INVALID)
    @Size(max = 44, message = ErrorMsg.LONG_EMAIL)
    @Column(name="email")
    private String email;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
