package com.portal.job.controller;

import com.portal.job.domain.User;
import com.portal.job.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(
            value = "/users"
    )
    public User getOrSave(@RequestBody User user) {
        return userService.getOrSave(user);
    }

    @GetMapping(value = "/users/{username}")
    public User getUser(@PathVariable("username") String username) {
        return userService.getUser(username);
    }
}
