package com.cs544.video.rating.userservice.dto;

import com.cs544.video.rating.userservice.model.User;
import com.cs544.video.rating.userservice.model.UserRating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRatingVideo {

    private UserRating userRating;
    private User user;
    private Video video;

}
