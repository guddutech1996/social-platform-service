package com.socialservice.controllers;


import com.socialservice.entity.User;
import com.socialservice.entity.UserProfile;
import com.socialservice.exceptions.UserNotFoundException;
import com.socialservice.manager.UserManager;
import com.socialservice.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user_profile")
public class UserProfileController {

    @Autowired private UserProfileService userProfileService;

    @Autowired private UserManager userManager;

    @PutMapping("")
    public UserProfile updateProfile(@RequestParam String email
            , @RequestBody UserProfile userProfile) throws UserNotFoundException {
        User user = userManager.getUserByEmail(email);
        UserProfile existingProfile = userProfileService.getUserProfileByUserId(user.getId());
        userProfile.setUserId(user.getId());
        userProfile.setId(existingProfile.getId());
        return userProfileService.updateUserProfile(userProfile);
    }

    @PostMapping("")
    public UserProfile createProfile(@RequestParam String email)  throws UserNotFoundException{
        User user = userManager.getUserByEmail(email);
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(user.getId());
        return userProfileService.updateUserProfile(userProfile);
    }
}
