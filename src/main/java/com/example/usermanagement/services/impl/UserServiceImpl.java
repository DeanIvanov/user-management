package com.example.usermanagement.services.impl;

import com.example.usermanagement.exceptions.DuplicateEntityException;
import com.example.usermanagement.exceptions.EntityNotFoundException;
import com.example.usermanagement.models.User;
import com.example.usermanagement.repositories.UserRepository;
import com.example.usermanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(int id, User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEntityException(String.format("User with this email address (%s) already exists!", user.getEmail()));
        }
        //TODO add authority assignment here, create user through security and start using update method here instead

        userRepository.save(user);
    }

    @Override
    public void update(int id, User user) {
        if(!userRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format("User with this ID (%s) does not exist!", id));
        }
        User newUser = userRepository.getById(id);
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setDob(user.getDob());
        newUser.setPhone(user.getPhone());
        newUser.setEmail(user.getEmail());
        //TODO add password when security is implemented

        userRepository.save(newUser);
    }

    @Override
    public void delete(User user) {
        if(!userRepository.existsById(user.getId())) {
            throw new EntityNotFoundException(String.format("User with this ID (%s) does not exist!", user.getId()));
        }
        userRepository.delete(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllOrderedBySurname() {
        return userRepository.findAllByOrderBySurnameAsc();
    }

    @Override
    public List<User> getAllOrderedByDob() {
        return userRepository.findAllByOrderByDobAsc();
    }

    @Override
    public List<User> searchUsers(String search) {
        return userRepository.findAllByNameOrSurnameOrEmailOrPhone(search,search,search,search);
    }

    @Override
    public User getById(int id) {
        if(!userRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format("User with this ID (%s) does not exist!", id));
        }
        return userRepository.getById(id);
    }

    @Override
    public User getByEmail(String email) {
        if(!userRepository.existsByEmail(email)) {
            throw new DuplicateEntityException(String.format("User with this email address (%s) does not exist!", email));
        }
        return userRepository.getByEmail(email);
    }

    @Override
    public User getCurrentUser() {
        //TODO enable after security is implemented
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //return getByUsername(authentication.getName());
        return null;
    }
}
