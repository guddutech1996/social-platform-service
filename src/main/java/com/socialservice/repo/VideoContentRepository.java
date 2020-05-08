package com.socialservice.repo;

import com.socialservice.entity.VideoContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoContentRepository extends JpaRepository<VideoContent,Long> {

    @Query(value = "select * from video_content order by priority desc",nativeQuery = true)
    List<VideoContent> getPopularVideos();

    @Query(value = "select * from video_content where id in :ids  order by priority desc",nativeQuery = true)
    List<VideoContent> getVideos(List<Long> ids);
}
