package com.cs544.video.rating.userservice.service;

import com.cs544.video.rating.userservice.dto.UserRatingVideo;
import com.cs544.video.rating.userservice.dto.Video;
import com.cs544.video.rating.userservice.model.User;
import com.cs544.video.rating.userservice.model.UserRating;
import com.cs544.video.rating.userservice.repository.IUserRatingRepository;
import com.cs544.video.rating.userservice.repository.IUserRepository;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.entity.BasicHttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
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
        UserRating rating = this.userRatingRepository.findById(userRatingId).get();
        User user = this.userRepository.findById(rating.getUserId()).get();


        String plainCreds = "user:user";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);


        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        org.springframework.http.HttpEntity<Video> request = new org.springframework.http.HttpEntity<Video>(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Video> response = restTemplate.exchange("http://localhost:9111/videos/"+rating.getVideoId(), HttpMethod.GET, request, Video.class);
        Video video = response.getBody();

        UserRatingVideo urv = new UserRatingVideo();
        urv.setUserRating(rating);
        urv.setVideo(video);
        urv.setUser(user);

        return urv;
    }
}
