package com.rafi.javatest.Controller;

import com.rafi.javatest.Entity.User;
import com.rafi.javatest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> getUsers(@RequestParam(required = false) Long id) {
        if (id != null) {
            return List.of(userService.getUserById(id));
        }
        return userService.getAllUsers();
    }
}