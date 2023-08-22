package com.spring.controller;

import exception.UserNotFoundException;
import model.User;
import model.UserStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;
import repository.service.UserService;

import java.util.List;

@RestController
@ResponseBody
public class UserController {

    private final UserService userService = new UserService();

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/users/userLastId", method = RequestMethod.GET)
    public long getLastId() {
        return new UserRepository().findLastId();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public User getUserId(@PathVariable long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
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
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "users/{banUserById}", method = RequestMethod.GET)
    public ResponseEntity<Void> banUser(@PathVariable long id) throws UserNotFoundException {
        User user = new UserService().getUserById(id);
        user.setStatus(UserStatus.BAN);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "users/{unbanUserById}", method = RequestMethod.GET)
    public ResponseEntity<Void> unbanUser(@PathVariable long id) throws UserNotFoundException {
        User user = new UserService().getUserById(id);
        user.setStatus(UserStatus.ACTIVE);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
