package com.example.usermanagement.services.impl;

import com.example.usermanagement.exceptions.DuplicateEntityException;
import com.example.usermanagement.exceptions.EntityNotFoundException;
import com.example.usermanagement.models.User;
import com.example.usermanagement.repositories.UserRepository;
import com.example.usermanagement.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private UserDetailsManager userDetailsManager;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserDetailsManager userDetailsManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsManager = userDetailsManager;
    }

    @Override
    public void create(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEntityException(String.format("User with this email address (%s) already exists!", user.getEmail()));
        }
        if(userRepository.existsByUsername(user.getUsername())) {
            throw new DuplicateEntityException(String.format("User with this username (%s) already exists!", user.getUsername()));
        }

        User newUser = new User();
        newUser.setId(userRepository.findTopByOrderByIdDesc().getId()+1);
        newUser.setId(user.getId());
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setDob(user.getDob());
        newUser.setPhone(user.getPhone());
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setAuthority("ROLE_USER");
        newUser.setEnabled(true);

        userRepository.save(newUser);
    }

    @Override
    public void update(int id, User user, boolean enabled) {
        if(!userRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format("User with this ID (%s) does not exist!", id));
        }
        User newUser = userRepository.getById(id);

        if(!newUser.getEmail().equals(user.getEmail()) && userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEntityException(String.format("User with this email address (%s) already exists!", user.getEmail()));
        }
        if(!newUser.getUsername().equals(user.getUsername()) && userRepository.existsByUsername(user.getUsername())) {
            throw new DuplicateEntityException(String.format("User with this username (%s) already exists!", user.getUsername()));
        }

        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setDob(user.getDob());
        newUser.setPhone(user.getPhone());
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setAuthority("ROLE_USER");
        newUser.setEnabled(enabled);

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
    public User getByUsername(String username) {
        if(!userRepository.existsByUsername(username)) {
            throw new DuplicateEntityException(String.format("User with this username (%s) does not exist!", username));
        }
        return userRepository.getByUsername(username);
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return getByUsername(authentication.getName());
    }
}
