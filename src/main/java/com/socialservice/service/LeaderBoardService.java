package com.socialservice.service;

import com.socialservice.entity.UserProfile;
import com.socialservice.exceptions.UserNotFoundException;
import org.springframework.stereotype.Component;

@Component
public interface LeaderBoardService {

    public UserProfile getLeaderBoardForUser(String email) throws UserNotFoundException;
}
