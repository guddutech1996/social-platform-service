package com.socialservice.service.impl;

import com.socialservice.entity.User;
import com.socialservice.entity.UserFriend;
import com.socialservice.exceptions.UserNotFoundException;
import com.socialservice.manager.UserManager;
import com.socialservice.repo.UserActivityRepository;
import com.socialservice.repo.UserFriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialservice.service.NewsFeedService;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsFeedServiceImpl implements NewsFeedService {

    @Autowired private UserManager userManager;

    @Autowired private UserFriendRepository userFriendRepository;

    @Autowired private UserActivityRepository userActivityRepository;

    @Override
    public List<User> getFriendList(String emailId) throws UserNotFoundException {
        List<User> userFriendResponses = new ArrayList<>();
        User user = userManager.getUserByEmail(emailId);
        List<UserFriend> userFriends = userFriendRepository.getUserFriends(user.getId());
        for(UserFriend userFriend : userFriends ){
            User friend  = null;
            if(userFriend.getUserId() == user.getId()){
                friend = userManager.getUserByUserId(userFriend.getPeerId());
            } else {
                friend = userManager.getUserByUserId(userFriend.getUserId());
            }

            userFriendResponses.add(friend);
        }
        return userFriendResponses;
    }
}
