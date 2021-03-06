package com.socialservice.controllers;

import com.socialservice.auth.AuthenticateClient;
import com.socialservice.constants.URIEndpoints;
import com.socialservice.constants.admin.Constants;
import com.socialservice.entity.User;
import com.socialservice.exceptions.UserNotFoundException;
import com.socialservice.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AuthenticateClient
@RestController
public class LoginController {

    @Autowired private UserManager userManager;

    @PostMapping(URIEndpoints.ACTIVE)
    public User active(@RequestParam String email) throws UserNotFoundException{
        User user = userManager.getUserByEmail(email);
        user.setStatus(Constants.USER_ONLINE_STATUS);
        return userManager.createUser(user);
    }

    @PostMapping(URIEndpoints.INACTIVE)
    public User inactive(@RequestParam String email) throws UserNotFoundException {
        User user = userManager.getUserByEmail(email);
        user.setStatus(Constants.USER_OFFLINE_STATUS);
        return userManager.createUser(user);
    }

}
