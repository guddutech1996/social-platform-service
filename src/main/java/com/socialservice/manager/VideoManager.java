package com.socialservice.manager;

import com.socialservice.entity.VideoContent;
import com.socialservice.repo.VideoContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoManager {

    @Autowired private VideoContentRepository videoContentRepository;

    public VideoContent saveVideo(VideoContent videoContent){
        return videoContentRepository.save(videoContent);
    }
}
