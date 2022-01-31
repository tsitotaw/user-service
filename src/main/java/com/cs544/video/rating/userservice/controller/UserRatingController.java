package com.cs544.video.rating.userservice.controller;

import com.cs544.video.rating.userservice.dto.UserWatchListVideo;
import com.cs544.video.rating.userservice.model.UserWatchList;
import com.cs544.video.rating.userservice.service.IUserWatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userratings")
public class UserRatingController {

    @Autowired
    private IUserWatchListService userRatingService;

    @GetMapping("/{id}")
    public UserWatchListVideo getUserRatingByIdWithVideo(@PathVariable("id") Long userRatingId){
        return this.userRatingService.getUserRatingByIdWithVideo(userRatingId);
    }

    @GetMapping("/")
    public List<UserWatchList> getAllUsers(){
        return this.userRatingService.getAll();
    }

    @PostMapping("/")
    public UserWatchList saveUser(@RequestBody UserWatchList userRating){
        return this.userRatingService.saveUserRating(userRating);
    }
}
