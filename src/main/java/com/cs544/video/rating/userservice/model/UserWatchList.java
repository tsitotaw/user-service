package com.cs544.video.rating.userservice.model;

import com.sun.istack.NotNull;
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
public class UserWatchList {

    @Id
    @GeneratedValue
    private Long userRatingId;

    @NotNull
    private Long userId;
    @NotNull
    private Long videoId;
    private Integer rating;
}
