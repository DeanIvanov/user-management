package com.example.usermanagement.controllers;

import com.example.usermanagement.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showHomePage() {

        return "index";
    }

    @GetMapping("create")
    public String createUser() {

        return "create-user";
    }

    @GetMapping("update")
    public String updateUser() {

        return "update-user";
    }

    @GetMapping("delete")
    public String deleteUser() {

        return "delete-user";
    }

    @GetMapping("soft-delete")
    public String softDeleteUser() {

        return "soft-delete-user";
    }

    @GetMapping("user")
    public String showUser() {

        return "user";
    }
    @GetMapping("users")
    public String showAllUsers() {

        return "users";
    }

    @GetMapping("users-dob")
    public String showAllUsersByDoB() {

        return "users-dob";
    }

    @GetMapping("users-surname")
    public String showAllUsersBySurname() {

        return "users-surname";
    }

    @GetMapping("search")
    public String searchUsers() {

        return "users-search";
    }

}
