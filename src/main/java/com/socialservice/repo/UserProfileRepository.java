package com.socialservice.repo;

import com.socialservice.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {

    @Query(value = "select * from user_profile where user_id = ?1",nativeQuery = true)
    UserProfile getUserProfile(Long userId);

}
