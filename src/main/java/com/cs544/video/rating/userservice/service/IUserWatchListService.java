package com.cs544.video.rating.userservice.service;

import com.cs544.video.rating.userservice.dto.UserWatchListVideo;
import com.cs544.video.rating.userservice.model.UserWatchList;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserWatchListService {
    UserWatchList getUserRatingById(Long userRatingId);
    List<UserWatchList> getAll();
    UserWatchList saveUserRating(UserWatchList userRating);
    void deleteWatchList(Long uwlId);

    UserWatchListVideo getUserRatingByIdWithVideo(Long userRatingId);
}
