package com.cs544.video.rating.userservice.service;

import com.cs544.video.rating.userservice.model.UserRating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserRatingService {
    UserRating getUserRatingById(Long userRatingId);
    List<UserRating> getAll();
    UserRating saveUserRating(UserRating userRating);
}
