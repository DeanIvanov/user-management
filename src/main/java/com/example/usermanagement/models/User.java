package com.example.usermanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @JsonIgnore
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    @Size(min = 3, max = 15, message = "First name should be between 3 and 15 characters.")
    String name;

    @Column(name = "surname")
    @Size (min = 3, max = 25, message = "Last name should be between 3 and 25 characters.")
    String surname;

    @Column(name = "dob")
    LocalDate dob;

    @Column(name = "phone")
    @Size (min = 8, max = 13, message = "Phone number should be between 8 and 13 digits.")
    String phone;

    @Column(name = "email")
    @Size (min = 10, max = 50, message = "Email address should be between 10 and 50 characters.")
    String email;

    @Column(name = "username")
    @Size (min = 3, max = 50, message = "Username should be between 3 and 50 characters.")
    String username;

    @Column(name = "password")
    String password;

    @JsonIgnore
    @Column(name = "authority")
    private String authority;

    @JsonIgnore
    @Column(name = "enabled")
    boolean enabled;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
