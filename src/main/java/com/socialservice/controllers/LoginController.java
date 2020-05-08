package com.socialservice.controllers;

import com.socialservice.constants.URIEndpoints;
import com.socialservice.entity.User;
import com.socialservice.exceptions.UserNotFoundException;
import com.socialservice.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired private UserManager userManager;

    @PostMapping(URIEndpoints.ACTIVE)
    public User active(@RequestParam String email) throws UserNotFoundException{
        User user = userManager.getUserByEmail(email);
        user.setStatus("active");
        return userManager.createUser(user);
    }

    @PostMapping(URIEndpoints.INACTIVE)
    public User inactive(@RequestParam String email) throws UserNotFoundException {
        User user = userManager.getUserByEmail(email);
        user.setStatus("inactive");
        return userManager.createUser(user);
    }

}
