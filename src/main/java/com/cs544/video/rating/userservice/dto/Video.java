package com.cs544.video.rating.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    private Long videoId;
    private String videoTitle;
    private String videoGenre;
}
