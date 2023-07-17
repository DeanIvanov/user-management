package com.example.usermanagement.services;

import com.example.usermanagement.models.User;

import java.util.List;

public interface UserService {

    void create(User user);

    void update(int id, User user, boolean enabled);

    void delete(User user);

    List<User> getAll();

    List<User> getAllOrderedBySurname();

    List<User> getAllOrderedByDob();

    List<User> searchUsers(String search);

    User getById(int id);

    User getByEmail(String email);

    User getByUsername(String username);

    User getCurrentUser();
}
