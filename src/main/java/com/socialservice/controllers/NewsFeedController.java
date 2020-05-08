package com.socialservice.controllers;

import com.socialservice.auth.AuthenticateClient;
import com.socialservice.constants.URIEndpoints;
import com.socialservice.entity.User;
import com.socialservice.exceptions.UnauthorizedAccessException;
import com.socialservice.exceptions.UserNotFoundException;
import com.socialservice.service.NewsFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AuthenticateClient
@RestController
public class NewsFeedController {

    @Autowired private NewsFeedService newsFeedService;

    /**
     * This API gives user friends.
     * param String email
     * @return List<User>
     */
    @GetMapping(URIEndpoints.GET_FRIENDS_LIST)
    public List<User> getFriends(@RequestParam(value = "email") String email) throws UserNotFoundException{
        return newsFeedService.getFriendList(email);
    }
}
