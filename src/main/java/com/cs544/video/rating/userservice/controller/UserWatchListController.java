package com.cs544.video.rating.userservice.controller;

import com.cs544.video.rating.userservice.dto.UserWatchListVideo;
import com.cs544.video.rating.userservice.model.User;
import com.cs544.video.rating.userservice.model.UserWatchList;
import com.cs544.video.rating.userservice.service.IUserWatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/userwatchlists")
public class UserWatchListController {

    @Autowired
    private IUserWatchListService userWatchListService;

    @GetMapping("/{id}")
    public UserWatchListVideo getUserWatchListByIdWithVideo(@PathVariable("id") Long userRatingId){
        return this.userWatchListService.getUserRatingByIdWithVideo(userRatingId);
    }

    @GetMapping("/")
    public List<UserWatchList> getAllUserWatchLists(){
        return this.userWatchListService.getAll();
    }

    @PostMapping("/")
    public RedirectView saveUserWatchList(@RequestBody UserWatchList userRating){
        UserWatchList uwl = this.userWatchListService.saveUserRating(userRating);
        return new RedirectView("/userwatchlists/" + uwl.getUserId());
    }

    @DeleteMapping("/{id}")
    public void deleteUserWatchList(@PathVariable("id") Long userWatchListId){
        this.userWatchListService.deleteWatchList(userWatchListId);

    }
}
