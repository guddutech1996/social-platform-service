package com.socialservice.controller;

import com.socialservice.controllers.NewsFeedController;
import com.socialservice.service.NewsFeedService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureDataJpa
@WebMvcTest(controllers= NewsFeedController.class)
public class NewsFeedControllerTest {

    private MockMvc mockMvc;

    @Autowired private WebApplicationContext webApplicationContext;

    @MockBean private NewsFeedService newsFeedService;

    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        when(newsFeedService.getFriendList(anyString())).thenReturn(new ArrayList<>());
    }

    @Test
    public void testGetFriendsApi() throws Exception {
        mockMvc.perform(get("/friends").param("email", "rgamangarg@gmail.com"))
                .andExpect(status().isOk());
    }

}
