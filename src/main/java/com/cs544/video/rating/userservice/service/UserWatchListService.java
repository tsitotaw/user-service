package com.cs544.video.rating.userservice.service;

import com.cs544.video.rating.userservice.dto.UserWatchListVideo;
import com.cs544.video.rating.userservice.dto.Video;
import com.cs544.video.rating.userservice.model.User;
import com.cs544.video.rating.userservice.model.UserWatchList;
import com.cs544.video.rating.userservice.repository.IUserWatchListRepository;
import com.cs544.video.rating.userservice.repository.IUserRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import java.util.List;

@Service
public class UserWatchListService implements IUserWatchListService {
    @Autowired
    private IUserWatchListRepository userWatchListRepository;
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.credential}")
    private String credential;
    @Value("${user.videoUrl}")
    private String videoUrl;

    @Override
    public UserWatchList getUserRatingById(Long userRatingId) {
        return userWatchListRepository.findById(userRatingId).get();
    }

    @Override
    public List<UserWatchList> getAll() {
        return userWatchListRepository.findAll();
    }

    @Override
    public UserWatchList saveUserRating(UserWatchList userRating) {
        return userWatchListRepository.save(userRating);
    }

    @Override
    public void deleteWatchList(Long uwlId) {
        this.userWatchListRepository.deleteById(uwlId);
    }

    @Transactional
    @Override
    public UserWatchListVideo getUserRatingByIdWithVideo(Long userRatingId) {
        UserWatchList rating = this.userWatchListRepository.findById(userRatingId).get();
        User user = this.userRepository.findById(rating.getUserId()).get();
        String url = this.videoUrl.substring(1, this.videoUrl.length()-1);
        ResponseEntity<Video> response = new RestTemplate().exchange(url + rating.getVideoId(), HttpMethod.GET, this.getProperAuthorizationHeader(),Video.class);
        Video video = response.getBody();

        UserWatchListVideo urv = new UserWatchListVideo();
        urv.setUserRating(rating);
        urv.setVideo(video);
        urv.setUser(user);

        return urv;
    }

    private String getBase64Credential(){
        String plainCreds = this.credential.substring(1, this.credential.length()-1);
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        return new String(base64CredsBytes);
    }

    private HttpEntity<Video> getProperAuthorizationHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + this.getBase64Credential());
        return new HttpEntity<Video>(headers);
    }


}
