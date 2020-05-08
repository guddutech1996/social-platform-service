package com.socialservice.service;

import com.socialservice.entity.User;
import com.socialservice.exceptions.UserNotFoundException;
import com.socialservice.response.UserFriendResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NewsFeedService {

    List<User> getFriendList(String emailId) throws UserNotFoundException;

}
