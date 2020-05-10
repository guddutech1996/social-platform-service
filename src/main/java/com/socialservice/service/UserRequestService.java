package com.socialservice.service;

import com.socialservice.entity.UserFriend;
import com.socialservice.exceptions.UserNotFoundException;
import org.springframework.stereotype.Component;

@Component
public interface UserRequestService {
    UserFriend addFriend(String userEmail, String friendEmail) throws UserNotFoundException;
    UserFriend acceptRequest(String userEmail, String friendEmail) throws UserNotFoundException;
}
