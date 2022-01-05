package com.userscore.userScore.controller;

import com.userscore.userScore.entity.User;
import com.userscore.userScore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/user",method = POST)
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    // update user
    @RequestMapping(value = "/user",method = PUT)
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

}
