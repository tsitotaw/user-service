package com.cs544.video.rating.userservice.controller;

import com.cs544.video.rating.userservice.model.User;
import com.cs544.video.rating.userservice.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long userId){
        return this.userService.getUserById(userId);

    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return this.userService.getAll();
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return this.userService.saveUser(user);
    }
}
