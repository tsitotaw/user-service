package com.cs544.video.rating.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRating {

    @Id
    @GeneratedValue
    private Long userRatingId;

    private Long userId;
    private Long videoId;
    private Integer rating;
}
