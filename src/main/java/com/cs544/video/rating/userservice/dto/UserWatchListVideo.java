package com.cs544.video.rating.userservice.dto;

import com.cs544.video.rating.userservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWatchListVideo {

    private com.cs544.video.rating.userservice.model.UserWatchList userRating;
    private User user;
    private Video video;

}
