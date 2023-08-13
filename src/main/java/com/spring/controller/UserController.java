package com.spring.controller;

import exception.UserNotFoundException;
import model.User;
import model.UserStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;
import service.UserService;

import java.util.List;

@RestController
public class UserController {


    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return new UserService().getAllUsers();
    }

    @GetMapping(value = "/users/userLastId")
    public long getLastId() {
        return new UserRepository().findLastId();
    }

    @GetMapping(value = "/users/userId/{id}")
    public User getUserId(@PathVariable long id) throws UserNotFoundException {
        return new UserService().getUserById(id);
    }


    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user) {
        user.setStatus(UserStatus.ACTIVE);
        new UserService().saveUser(user);
        return "ready";
    }

    @PutMapping(value = "users/updateUser/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User update) throws UserNotFoundException {
        User user = new UserService().getUserById(id);
        user.setUsername(update.getUsername());
        user.setPassword(update.getPassword());
        user.setName(update.getName());
        user.setSurname(update.getSurname());
        user.setEmail(update.getEmail());
        return "ready";
    }

    @GetMapping(value = "users/banUserById/{id}")
    public String banUser(@PathVariable long id) throws UserNotFoundException {
        User user = new UserService().getUserById(id);
        user.setStatus(UserStatus.BAN);
        return "ready";
    }

    @GetMapping(value = "users/unbanUserById/{id}")
    public String unbanUser(@PathVariable long id) throws UserNotFoundException {
        User user = new UserService().getUserById(id);
        user.setStatus(UserStatus.ACTIVE);
        return "ready";
    }
}


