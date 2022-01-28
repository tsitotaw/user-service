package com.cs544.video.rating.userservice.service;

import com.cs544.video.rating.userservice.model.User;
import com.cs544.video.rating.userservice.model.UserRating;
import com.cs544.video.rating.userservice.repository.IUserRatingRepository;
import com.cs544.video.rating.userservice.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserRatingService implements IUserRatingService{
    @Autowired
    private IUserRatingRepository userRatingRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserRating getUserRatingById(Long userRatingId) {
        return userRatingRepository.findById(userRatingId).get();
    }

    @Override
    public List<UserRating> getAll() {
        return userRatingRepository.findAll();
    }

    @Override
    public UserRating saveUserRating(UserRating userRating) {
        return userRatingRepository.save(userRating);
    }
}
