package com.socialservice.controller;


import com.socialservice.controllers.HealthController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class HealthControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(HealthController.class).build();
    }

    @Test
    public void testPingPong() throws Exception {
        String response = mockMvc.perform(get("/ping"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assert.assertEquals("pong", response);
    }
}
