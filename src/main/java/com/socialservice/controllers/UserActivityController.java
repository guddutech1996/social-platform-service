package com.socialservice.controllers;

import com.socialservice.auth.AuthenticateClient;
import com.socialservice.constants.admin.URIEndpoints;
import com.socialservice.entity.UserActivity;
import com.socialservice.exceptions.UserNotFoundException;
import com.socialservice.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AuthenticateClient
@RestController
public class UserActivityController {

    @Autowired private UserActivityService userActivityService;

    @PostMapping(value = URIEndpoints.ADD_FAVOURITE_VIDEO)
    public UserActivity addVideoToFavourites(@RequestParam String email
            , @RequestBody UserActivity userActivity) throws UserNotFoundException {
        return userActivityService.addVideoToUserFavourites(email,userActivity);
    }
}
