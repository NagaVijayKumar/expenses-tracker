package com.vijaykumar.user.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "jb-user")
public class User {
    @Id
    @Indexed(unique = true)
    private String email;

    private String firstName;
    private String lastName;
    private long DueAmount;



    public User() {
    }



    public User(String firstName, String lastName, String email, long DueAmount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.DueAmount = DueAmount;
    }
    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public long getDueAmount() {
        return DueAmount;
    }

    public void setDueAmount(long dueAmount) {
        DueAmount = dueAmount;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DueAmount=" + DueAmount +
                '}';
    }
}
