package com.socialservice.controllers;

import com.socialservice.constants.URIEndpoints;
import com.socialservice.entity.UserFriend;
import com.socialservice.exceptions.UserNotFoundException;
import com.socialservice.service.UserRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRequestController {

    @Autowired UserRequestService userRequestService;

    @PostMapping(URIEndpoints.ADD_FRIEND)
    public UserFriend addFriend(@RequestParam("user_email") String userEmail
            , @RequestParam("friend_email") String friendEmail ) throws UserNotFoundException {
        return userRequestService.addFriend(userEmail,friendEmail);
    }

    @PatchMapping(URIEndpoints.ADD_FRIEND)
    public UserFriend acceptRequest(@RequestParam("user_email") String userEmail
            , @RequestParam("friend_email") String friendEmail ) throws UserNotFoundException{
        return userRequestService.acceptRequest(userEmail,friendEmail);
    }


}
