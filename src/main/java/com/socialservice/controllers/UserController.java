package com.socialservice.controllers;


import com.socialservice.constants.admin.URIEndpoints;
import com.socialservice.entity.User;
import com.socialservice.exceptions.UserNotFoundException;
import com.socialservice.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired private UserManager userManager;

    @PostMapping(URIEndpoints.CREATE_USER)
    public User createUser(@RequestBody User user) throws UserNotFoundException {
        return userManager.createUser(user);
    }

    @GetMapping(URIEndpoints.GET_USER)
    public User createUser(@PathVariable Long id) throws UserNotFoundException{
        return userManager.getUserByUserId(id);
    }
}
