package com.userscore.userScore.service;

import com.userscore.userScore.entity.UserProgress;
import com.userscore.userScore.repository.UserProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProgressService {

    @Autowired
    private UserProgressRepository userProgressRepository;


    public UserProgress createUserProgress(UserProgress userProgress) {
        return userProgressRepository.save(userProgress);
    }

    public UserProgress updateUserProgress(UserProgress userProgress) {
        Optional<UserProgress> userProgressOptional = userProgressRepository.findById(userProgress.getId());
        if (userProgressOptional.isPresent()) {
            UserProgress userProgress1 = userProgressOptional.get();
            userProgress1.setScore(userProgress.getScore());
            userProgress1.setLevel(userProgress.getLevel());
            userProgress1.setUser(userProgress.getUser());
            return userProgressRepository.save(userProgress1);
        }
        return null;
    }
}
