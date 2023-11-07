package com.spring.controller;

import exception.UserNotFoundException;
import model.User;
import model.UserStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService = new UserService();

   @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserId(@PathVariable long id) {
        User user;
        try {
            user = new UserService().getUserById(id);

        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
        user.setStatus(UserStatus.ACTIVE);
        userService.saveUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "users/updateUser/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(@PathVariable long id, @RequestBody User update) {

        try {
            User user = new UserService().getUserById(id);
            user.setUsername(update.getUsername());
            user.setPassword(update.getPassword());
            user.setName(update.getName());
            user.setSurname(update.getSurname());
            user.setEmail(update.getEmail());
        }
         catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "users/ban/{id}", method = RequestMethod.GET)
    public ResponseEntity<Void> banUser(@PathVariable long id) {
        try {
            User user = new UserService().getUserById(id);
            user.setStatus(UserStatus.BAN);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "users/unban/{id}", method = RequestMethod.GET)
    public ResponseEntity<Void> unbanUser(@PathVariable long id) {
        try {
            User user = new UserService().getUserById(id);
            user.setStatus(UserStatus.ACTIVE);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
