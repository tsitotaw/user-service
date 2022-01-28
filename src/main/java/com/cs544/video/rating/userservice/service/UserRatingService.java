package com.cs544.video.rating.userservice.service;

import com.cs544.video.rating.userservice.dto.UserRatingVideo;
import com.cs544.video.rating.userservice.dto.Video;
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
    private IUserRepository userRepository;

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

    @Override
    public UserRatingVideo getUserRatingByIdWithVideo(Long userRatingId) {
        UserRating rating = this.userRatingRepository.getById(userRatingId);
        User user = this.userRepository.getById(rating.getUserId());

        Video video = this.restTemplate.getForObject("http://VR-API-GATEWAY/videos/"+rating.getVideoId(), Video.class);

        UserRatingVideo urv = new UserRatingVideo();
        urv.setUserRating(rating);
        urv.setVideo(video);
        urv.setUser(user);

        return urv;
    }
}
