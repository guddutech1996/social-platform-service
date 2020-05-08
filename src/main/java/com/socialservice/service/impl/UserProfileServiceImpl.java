package com.socialservice.service.impl;

import com.socialservice.entity.UserProfile;
import com.socialservice.repo.UserProfileRepository;
import com.socialservice.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired private UserProfileRepository userProfileRepository;

    @Override
    public UserProfile updateUserProfile(UserProfile userProfile){
        return userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile getUserProfileByUserId(Long userId){
        return userProfileRepository.getUserProfile(userId);
    }

}
