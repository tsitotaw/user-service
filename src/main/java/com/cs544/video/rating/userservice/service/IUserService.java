package com.cs544.video.rating.userservice.service;

import com.cs544.video.rating.userservice.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    User getUserById(Long userId);
    List<User> getAll();
    User saveUser(User user);
}
