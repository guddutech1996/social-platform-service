// package com.socialservice.controller;

// import com.socialservice.controllers.VideoController;
// import com.socialservice.entity.VideoContent;
// import com.socialservice.service.VideoService;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;
// import org.springframework.web.context.WebApplicationContext;

// import java.util.ArrayList;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static reactor.core.publisher.Mono.when;
// import static org.mockito.ArgumentMatchers.anyString;


// @RunWith(SpringRunner.class)
// @AutoConfigureDataJpa
// @WebMvcTest(controllers= VideoController.class)
// public class VideoControllerTest {

//     private MockMvc mockMvc;

//     @Autowired private WebApplicationContext webApplicationContext;

//     @MockBean private VideoService videoService;

//     @Before
//     public void setup() throws Exception {
//         mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//         when(videoService.getFavouriteVideos(anyString())).thenReturn(new ArrayList<>());
//     }

//     @Test
//     public void testFavouriteVideosApi() throws Exception {
//         mockMvc.perform(get("/videos/favourites").param("email", "rgamangarg@gmail.com"))
//                 .andExpect(status().isOk());
//     }

//     @Test
//     public void testPopularVideosApi() throws Exception {
//         mockMvc.perform(get("/videos/popular"))
//                 .andExpect(status().isOk());
//     }
// }
