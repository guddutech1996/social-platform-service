package com.socialservice.repo;

import com.socialservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "select * from users where email_id = ?1",nativeQuery = true)
    User getUserByEmail(String emailId);

    @Query(value = "select * from users where id = ?1",nativeQuery = true)
    User getUserById(Long userId);

}
