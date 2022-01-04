package com.userscore.userScore.controller;

import com.userscore.userScore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LeaderBoardController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getToTenUsers")
    public ResponseEntity<?> getToTenUsers() {
        return ResponseEntity.ok(userService.getToTenUsers());
    }

    @RequestMapping("/userScore/{userId}")
    public ResponseEntity<?> getUserScoreByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserScoreByUserId(userId));
    }
}
