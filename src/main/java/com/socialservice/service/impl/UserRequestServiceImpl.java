package com.socialservice.service.impl;

import com.socialservice.entity.User;
import com.socialservice.entity.UserFriend;
import com.socialservice.exceptions.UserNotFoundException;
import com.socialservice.manager.UserManager;
import com.socialservice.repo.UserFriendRepository;
import com.socialservice.service.UserRequestService;
import com.socialservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRequestServiceImpl  implements UserRequestService {

    @Autowired UserManager userManager;

    @Autowired private UserFriendRepository userFriendRepository;

    @Override
    public UserFriend addFriend(String userEmail, String friendEmail) throws UserNotFoundException {
        User user = userManager.getUserByEmail(userEmail);
        User friend = userManager.getUserByEmail(friendEmail);
        UserFriend userFriend = new UserFriend();
        userFriend.setRequester(user.getId());
        userFriend.setUserId(Math.min(user.getId(),friend.getId()));
        userFriend.setPeerId(Math.max(user.getId(),friend.getId()));
        userFriend.setStatus("requested");
        userFriendRepository.save(userFriend);
        return userFriend;
    }

    @Override
    public UserFriend acceptRequest(String userEmail, String friendEmail) throws UserNotFoundException{
        User user = userManager.getUserByEmail(userEmail);
        User friend = userManager.getUserByEmail(friendEmail);
        UserFriend userFriend = userFriendRepository.getUserFriend(user.getId(),friend.getId());
        userFriend.setStatus("friend");
        userFriendRepository.save(userFriend);
        return userFriend;
    }
}
