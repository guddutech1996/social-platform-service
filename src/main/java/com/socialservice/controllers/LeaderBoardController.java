package com.socialservice.controllers;

import com.socialservice.constants.URIEndpoints;
import com.socialservice.entity.UserProfile;
import com.socialservice.exceptions.UserNotFoundException;
import com.socialservice.service.LeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaderBoardController {

    @Autowired private LeaderBoardService leaderBoardService;

    //TODO:: Authorization on APIS
    @GetMapping(URIEndpoints.LEADERBOARD)
    public UserProfile getLeaderBoardForUser(@RequestParam String email) throws UserNotFoundException {
        return leaderBoardService.getLeaderBoardForUser(email);
    }
}
