package com.cs544.video.rating.userservice.controller;

import com.cs544.video.rating.userservice.dto.UserWatchListVideo;
import com.cs544.video.rating.userservice.model.UserWatchList;
import com.cs544.video.rating.userservice.service.IUserWatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userwatchlists")
public class UserWatchListController {

    @Autowired
    private IUserWatchListService userWatchListService;

    @GetMapping("/{id}")
    public UserWatchListVideo getUserRatingByIdWithVideo(@PathVariable("id") Long userRatingId){
        return this.userWatchListService.getUserRatingByIdWithVideo(userRatingId);
    }

    @GetMapping("/")
    public List<UserWatchList> getAllUsers(){
        return this.userWatchListService.getAll();
    }

    @PostMapping("/")
    public UserWatchList saveUser(@RequestBody UserWatchList userRating){
        return this.userWatchListService.saveUserRating(userRating);
    }
}
