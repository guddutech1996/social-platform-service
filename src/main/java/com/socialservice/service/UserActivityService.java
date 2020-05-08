package com.socialservice.service;

import com.socialservice.entity.UserActivity;
import com.socialservice.exceptions.UserNotFoundException;
import org.springframework.stereotype.Component;

@Component
public interface UserActivityService {

    UserActivity addVideoToUserFavourites(String email, UserActivity userActivity) throws UserNotFoundException;
}
