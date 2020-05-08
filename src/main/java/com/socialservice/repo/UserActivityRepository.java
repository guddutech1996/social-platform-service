package com.socialservice.repo;

import com.socialservice.entity.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity,Long> {

    @Query(value = "select favourite_video_id from users_activity where user_id = ?1",nativeQuery = true)
    List<Long> getUserActivity(Long userId);
}
