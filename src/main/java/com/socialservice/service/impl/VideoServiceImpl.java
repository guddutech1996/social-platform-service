package com.socialservice.service.impl;

import com.socialservice.entity.User;
import com.socialservice.entity.UserActivity;
import com.socialservice.entity.VideoContent;
import com.socialservice.repo.UserActivityRepository;
import com.socialservice.repo.UserRepository;
import com.socialservice.repo.VideoContentRepository;
import com.socialservice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired private VideoContentRepository videoContentRepository;

    @Autowired private UserActivityRepository userActivityRepository;

    @Autowired private UserRepository userRepository;

    @Override
    public List<VideoContent> getPopularVideos(){
        return videoContentRepository.getPopularVideos() ;
    }

    @Override
    public List<VideoContent> getFavouriteVideos(String email){
        User user = userRepository.getUserByEmail(email);
        List<Long> favVideos = userActivityRepository.getUserActivity(user.getId());
        if(favVideos.isEmpty()){
            return new ArrayList<>();
        }
        return videoContentRepository.getVideos(favVideos);
    }
}
