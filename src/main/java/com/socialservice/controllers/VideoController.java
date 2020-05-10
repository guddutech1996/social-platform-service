package com.socialservice.controllers;


import com.socialservice.auth.AuthenticateClient;
import com.socialservice.constants.admin.URIEndpoints;
import com.socialservice.entity.VideoContent;
import com.socialservice.manager.VideoManager;
import com.socialservice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AuthenticateClient
@RestController
@RequestMapping(URIEndpoints.VIDEO_CONTENT_BASE)
public class VideoController {

    @Autowired private VideoManager videoManager;

    @Autowired private VideoService videoService;

    /**
     * This API gives popular/trending videos based on priority value in VideoContent Entity
     *
     * @return  List<VideoContent>
     */
    @GetMapping(com.socialservice.constants.URIEndpoints.GET_POPULAR_VIDOES)
    public List<VideoContent> getPopularVideos(){
        return videoService.getPopularVideos();
    }


    /**
     * This API gives user favourite videos based on priority value in VideoContent Entity
     * param String email
     * @return List<VideoContent>
     */
    @GetMapping(com.socialservice.constants.URIEndpoints.GET_FAVOURITE_VIDEOS)
    public List<VideoContent> getFavouriteVideos(@RequestParam(value = "email") String email){
        return videoService.getFavouriteVideos(email);
    }

    /**
     * This API gives used to create video content
     * RequestBody VideoContent
     * @return List<VideoContent>
     */

    @PostMapping(URIEndpoints.CREATE_VIDEO_CONTENT)
    public VideoContent createVideo(@RequestBody VideoContent videoContent){
        System.out.println(videoContent);
        return videoManager.saveVideo(videoContent);
    }
}
