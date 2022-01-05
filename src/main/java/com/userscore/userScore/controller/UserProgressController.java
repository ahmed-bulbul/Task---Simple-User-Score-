package com.userscore.userScore.controller;

import com.userscore.userScore.entity.UserProgress;
import com.userscore.userScore.service.UserProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@CrossOrigin(origins = "*")
public class UserProgressController {

    @Autowired
    private UserProgressService userProgressService;

    @RequestMapping(value = "/userProgress",method = POST)
    public UserProgress createUserProgress(@RequestBody  UserProgress userProgress){
        return this.userProgressService.createUserProgress(userProgress);
    }

    //update userProgress
    @RequestMapping(value = "/userProgress",method = PUT)
    public UserProgress updateUserProgress(@RequestBody UserProgress userProgress){
        return this.userProgressService.updateUserProgress(userProgress);
    }

}

