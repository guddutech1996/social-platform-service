package com.socialservice.controllers;


import com.socialservice.entity.VideoContent;
import com.socialservice.manager.VideoManager;
import com.socialservice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired private VideoManager videoManager;

    @Autowired private VideoService videoService;

    @GetMapping("/popular")
    public List<VideoContent> getPopularVideos(){
        return videoService.getPopularVideos();
    }

    @GetMapping("/favourites")
    public List<VideoContent> getFavouriteVideos(@RequestParam(value = "email") String email){
        return videoService.getFavouriteVideos(email);
    }

    @PostMapping("/create")
    public VideoContent createVideo(@RequestBody VideoContent videoContent){
        System.out.println(videoContent);
        return videoManager.saveVideo(videoContent);
    }
}
