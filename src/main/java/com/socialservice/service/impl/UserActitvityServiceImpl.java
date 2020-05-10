package com.socialservice.service.impl;

import com.socialservice.entity.User;
import com.socialservice.entity.UserActivity;
import com.socialservice.exceptions.UserNotFoundException;
import com.socialservice.manager.UserManager;
import com.socialservice.repo.UserActivityRepository;
import com.socialservice.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserActitvityServiceImpl implements UserActivityService {

    @Autowired private UserActivityRepository userActivityRepository;

    @Autowired private UserManager userManager;

    public UserActivity addVideoToUserFavourites(String email, UserActivity userActivity) throws UserNotFoundException {
        User user = userManager.getUserByEmail(email);
        userActivity.setUserId(user.getId());
        return userActivityRepository.save(userActivity);
    }
}
