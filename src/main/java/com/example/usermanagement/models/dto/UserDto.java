package com.example.usermanagement.models.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class UserDto {

    @NotNull
    @Size(min = 3, max = 15, message = "First name should be between 3 and 15 characters.")
    String name;

    @NotNull
    @Size (min = 3, max = 25, message = "Last name should be between 3 and 25 characters.")
    String surname;

    @NotNull
    LocalDate dob;

    @NotNull
    @Size (min = 8, max = 13, message = "Phone number should be between 8 and 13 digits.")
    String phone;

    @NotNull
    @Size (min = 10, max = 50, message = "Email address should be between 10 and 50 characters.")
    String email;

    String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
