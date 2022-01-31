package com.cs544.video.rating.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    private Long id;
    private String title;
    private String genre;
    private Date releaseDate;
    private Long ratingId;
}
