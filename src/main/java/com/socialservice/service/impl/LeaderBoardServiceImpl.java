package com.socialservice.service.impl;

import com.socialservice.entity.UserProfile;
import com.socialservice.entity.User;
import com.socialservice.exceptions.UserNotFoundException;
import com.socialservice.manager.UserManager;
import com.socialservice.repo.UserProfileRepository;
import com.socialservice.service.LeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaderBoardServiceImpl implements LeaderBoardService {

    @Autowired private UserManager userManager;

    @Autowired private UserProfileRepository userProfileRepository;

    @Override
    public UserProfile getLeaderBoardForUser(String email) throws UserNotFoundException {
        User user = userManager.getUserByEmail(email);
        return userProfileRepository.getUserProfile(user.getId());
    }
}
