package com.example.usermanagement.controllers;

import com.example.usermanagement.exceptions.DuplicateEntityException;
import com.example.usermanagement.exceptions.EntityNotFoundException;
import com.example.usermanagement.models.User;
import com.example.usermanagement.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get all users", description = "Get a list of all users in ascending order of their ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Users have been found.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Users not found.", content = @Content)})
    @GetMapping()
    public List<User> getAll() {
        try {
            return userService.getAll();
        }
        catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @Operation(summary = "Get all users", description = "Get a list of all users in ascending order of their Surname.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Users have been found.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Users not found.", content = @Content)})
    @GetMapping("/order/surname")
    public List<User> getAllOrderedBySurname() {
        try {
            return userService.getAllOrderedBySurname();
        }
        catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @Operation(summary = "Get all users", description = "Get a list of all users in ascending order of their Date of Birth(DoB).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Users have been found.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Users not found.", content = @Content)})
    @GetMapping("/order/dob")
    public List<User> getAllOrderedByDob() {
        try {
            return userService.getAllOrderedByDob();
        }
        catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @Operation(summary = "Get user by ID", description = "Get a single user by their ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - A user has been found with the specified ID.", content = @Content),
            @ApiResponse(responseCode = "404", description = "User with the specified ID has not been found.", content = @Content)})
    @GetMapping("/{id}")
    public User getUserById(@Parameter(description = "ID of the user that is to be displayed.", required = true)
                            @PathVariable int id) {
        try {
            return userService.getById(id);
        }
        catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @Operation(summary = "Get users by search", description = "Get a list of user by searching for a matching name, surname, phone number or email address.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - A user has been found with the searched name, surname phone number or email address.", content = @Content),
            @ApiResponse(responseCode = "404", description = "User with the searched name, surname phone number or email address has not been found.", content = @Content)})
    @GetMapping("/search/{search}")
    public List<User> getBySearch(@Parameter(description = "String with the name, surname, phone number or the email address of the users that we are searching for.", required = true)
                                  @PathVariable String search) {
        try {
            return userService.searchUsers(search);
        }
        catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @Operation(summary = "Create user", description = "Create a new user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - A user has been created.", content = @Content),
            @ApiResponse(responseCode = "409", description = "Duplication conflict - A user with this email address already exists.", content = @Content)})
    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        try {
            userService.create(user.getId(), user);
            return user;
        }
        catch (DuplicateEntityException exception) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, exception.getMessage());
        }
    }

    @Operation(summary = "Update user", description = "Update a user specified by their ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - the user has been updated.", content = @Content),
            @ApiResponse(responseCode = "404", description = "A user with the specified ID has not been found.", content = @Content)})
    @PutMapping("/update/{id}")
    public User updateUser(@Parameter(description = "ID of the user that is to be updated.", required = true)
                           @PathVariable int id, @RequestBody User newUser) {
        try {
            userService.update(id, newUser);
            return newUser;
        }
        catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @Operation(summary = "Delete a user", description = "Delete a user by removing them from the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - the user has been deleted.", content = @Content),
            @ApiResponse(responseCode = "404", description = "A user with the specified ID has not been found.", content = @Content)})
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@Parameter(description = "ID of the user that is to be deleted.", required = true)
                           @PathVariable int id) {
        try {
            userService.delete(userService.getById(id));
        }
        catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @Operation(summary = "Soft-delete a user", description = "Soft delete a user by disabling their access.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - the user has been soft deleted.", content = @Content),
            @ApiResponse(responseCode = "404", description = "A user with the specified ID has not been found.", content = @Content)})
    @PutMapping("/soft-delete/{id}")
    public void softDeleteUser(@Parameter(description = "ID of the user that is to be soft-deleted.", required = true)
                               @PathVariable int id) {
        try {
            User user = userService.getById(id);
//            user.setEnabled(false);
            userService.update(id, user);
        }
        catch (EntityNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }
}