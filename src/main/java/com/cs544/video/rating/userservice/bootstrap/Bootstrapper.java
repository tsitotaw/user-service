package com.cs544.video.rating.userservice.bootstrap;

import com.cs544.video.rating.userservice.model.User;
import com.cs544.video.rating.userservice.model.UserWatchList;
import com.cs544.video.rating.userservice.service.IUserWatchListService;
import com.cs544.video.rating.userservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrapper implements CommandLineRunner {

    @Autowired
    private IUserService userService;
    @Autowired
    private IUserWatchListService userRatingService;

    @Override
    public void run(String... args) throws Exception {
        this.userService.saveUser(new User(null, "User1", "1100 St, Fairfield Iowa", null));
        this.userService.saveUser(new User(null, "User2", "1090 St, Fairfield Iowa", null));
        this.userService.saveUser(new User(null, "User3", "1090 St, Ottoman Iowa", null));

        this.userRatingService.saveUserRating(new UserWatchList(null, 1L, 1L, 4));
        this.userRatingService.saveUserRating(new UserWatchList(null, 1L, 2L, 5));
        this.userRatingService.saveUserRating(new UserWatchList(null, 2L, 1L, 3));
    }
}
