package com.socialservice.response;


import com.socialservice.entity.User;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserFriendResponse {

    private User friend;

    private String status;
}
