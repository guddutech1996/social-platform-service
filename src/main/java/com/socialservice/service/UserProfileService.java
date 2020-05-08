package com.socialservice.service;

import com.socialservice.entity.UserProfile;

public interface UserProfileService {

    UserProfile updateUserProfile(UserProfile userProfile);
    UserProfile getUserProfileByUserId(Long userId);
}
