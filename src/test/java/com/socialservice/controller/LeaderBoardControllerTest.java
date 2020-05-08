package com.socialservice.controller;

import com.socialservice.controllers.LeaderBoardController;
import com.socialservice.controllers.NewsFeedController;
import com.socialservice.entity.UserProfile;
import com.socialservice.exceptions.UserNotFoundException;
import com.socialservice.service.LeaderBoardService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureDataJpa
@WebMvcTest(controllers= LeaderBoardController.class)
public class LeaderBoardControllerTest {

    @MockBean private LeaderBoardService leaderBoardService;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws UserNotFoundException {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        when(leaderBoardService.getLeaderBoardForUser(anyString())).thenReturn(new UserProfile());
    }

    @Test
    public void testLeaderBoardApiTests() throws Exception {
        mockMvc.perform(get("/leaderboard").param("email", "rgamangarg@gmail.com"))
                .andExpect(status().isOk());
    }

}
