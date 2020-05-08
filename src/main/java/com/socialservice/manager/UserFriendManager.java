package com.socialservice.manager;

import com.socialservice.entity.UserFriend;
import com.socialservice.repo.UserFriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFriendManager {

    @Autowired private UserFriendRepository userFriendRepository;

    public List<UserFriend> getUserFriendsByUserId(Long userId){
        return userFriendRepository.getUserFriends(userId);
    }
}
