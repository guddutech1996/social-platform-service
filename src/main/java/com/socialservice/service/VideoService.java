package com.socialservice.service;

import com.socialservice.entity.VideoContent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VideoService {

    List<VideoContent> getPopularVideos();

    List<VideoContent> getFavouriteVideos(String email);

}
