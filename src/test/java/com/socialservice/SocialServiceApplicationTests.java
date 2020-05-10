package com.socialservice;


import com.socialservice.entity.User;
import com.socialservice.entity.UserFriend;
import com.socialservice.repo.UserFriendRepository;
import com.socialservice.repo.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocialServiceApplicationTests {

    @Test
    public void contextLoads() { }
}
