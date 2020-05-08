package com.socialservice.manager;

import com.socialservice.entity.User;
import com.socialservice.entity.UserProfile;
import com.socialservice.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialservice.repo.UserRepository;

@Service
public class UserManager {

    @Autowired private UserRepository userRepository;

    public User getUserByEmail(String emailId) throws UserNotFoundException {
        User user =  userRepository.getUserByEmail(emailId);
        if(user == null)
            throw  new UserNotFoundException("User Not Found");
        return user;
    }
    public User getUserByUserId(Long userId) throws UserNotFoundException {
        User user = userRepository.getUserById(userId);
        if(user == null)
            throw new UserNotFoundException("User Not Found");
        return user;
    }
    public User createUser(User user){
        UserProfile userProfile = new UserProfile();
        user = userRepository.save(user);
        userProfile.setUserId(user.getId());
        return user;
    }
}
