package com.cs544.video.rating.userservice.controller;

import com.cs544.video.rating.userservice.model.User;
import com.cs544.video.rating.userservice.model.UserRating;
import com.cs544.video.rating.userservice.service.IUserRatingService;
import com.cs544.video.rating.userservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userratings")
public class UserRatingController {

    @Autowired
    private IUserRatingService userRatingService;

    @GetMapping("/{id}")
    public UserRating getUserById(@PathVariable("id") Long userRatingId){
        return this.userRatingService.getUserRatingById(userRatingId);
    }

    @GetMapping("/")
    public List<UserRating> getAllUsers(){
        return this.userRatingService.getAll();
    }

    @PostMapping("/")
    public UserRating saveUser(@RequestBody UserRating userRating){
        return this.userRatingService.saveUserRating(userRating);
    }
}
