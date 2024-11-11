package com.example.springbootexperiment.controller;

import com.example.springbootexperiment.entity.User;
import com.example.springbootexperiment.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public boolean saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public boolean removeUserById(@PathVariable Long id) {
        return userService.removeUserById(id);
    }

    @PutMapping
    public boolean updateUserById(@RequestBody User user) {
        return userService.updateUserById(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<User> listUser() {
        return userService.listUsers();
    }

    @GetMapping("/books/{username}")
    public User getUserAndBooksByUsername(@PathVariable String username) {
        return userService.getUserAndBooksByUserName(username);
    }
}
