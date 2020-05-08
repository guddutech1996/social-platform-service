package com.socialservice.controllers;


import com.socialservice.auth.AuthenticateClient;
import com.socialservice.entity.VideoContent;
import com.socialservice.manager.VideoManager;
import com.socialservice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AuthenticateClient
@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired private VideoManager videoManager;

    @Autowired private VideoService videoService;

    /**
     * This API gives popular/trending videos based on priority value in VideoContent Entity
     *
     * @return  List<VideoContent>
     */
    @GetMapping("/popular")
    public List<VideoContent> getPopularVideos(){
        return videoService.getPopularVideos();
    }


    /**
     * This API gives user favourite videos based on priority value in VideoContent Entity
     * param String email
     * @return List<VideoContent>
     */
    @GetMapping("/favourites")
    public List<VideoContent> getFavouriteVideos(@RequestParam(value = "email") String email){
        return videoService.getFavouriteVideos(email);
    }

    /**
     * This API gives used to create video content
     * RequestBody VideoContent
     * @return List<VideoContent>
     */

    @PostMapping("/create")
    public VideoContent createVideo(@RequestBody VideoContent videoContent){
        System.out.println(videoContent);
        return videoManager.saveVideo(videoContent);
    }
}
