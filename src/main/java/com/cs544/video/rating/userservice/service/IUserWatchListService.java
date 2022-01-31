package com.cs544.video.rating.userservice.service;

import com.cs544.video.rating.userservice.dto.UserWatchListVideo;
import com.cs544.video.rating.userservice.model.UserWatchList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserWatchListService {
    UserWatchList getUserRatingById(Long userRatingId);
    List<UserWatchList> getAll();
    UserWatchList saveUserRating(UserWatchList userRating);

    UserWatchListVideo getUserRatingByIdWithVideo(Long userRatingId);
}
