package com.socialservice.repo;

import com.socialservice.entity.UserFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFriendRepository extends JpaRepository<UserFriend, Long> {

    @Query(value = "select * from user_friends where (user_id =?1 or peer_id =?1) and status ='friend'",nativeQuery = true)
    List<UserFriend> getUserFriends(Long userId);

    @Query(value = "select * from user_friends where user_id =?1 and peer_id =?2",nativeQuery = true)
    UserFriend getUserFriend(Long userId, Long friendId);
}
