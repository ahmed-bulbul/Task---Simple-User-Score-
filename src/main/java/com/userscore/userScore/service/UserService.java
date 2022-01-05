package com.userscore.userScore.service;


import com.userscore.userScore.entity.User;
import com.userscore.userScore.entity.UserProgress;
import com.userscore.userScore.entity.UserProgressDTO;
import com.userscore.userScore.repository.UserProgressRepository;
import com.userscore.userScore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserProgressRepository userProgressRepository;

    @Autowired
    private UserRepository userRepository;



    public Object getToTenUsers() {
        int rank = 1;
        List<UserProgress> userList =  userProgressRepository.findFirst10ByOrderByScoreDesc();

        List<UserProgressDTO> userProgressDTOList=new ArrayList<>();

        for (UserProgress userProgress : userList) {
            UserProgressDTO userProgressDTO = new UserProgressDTO(userProgress,rank);
            userProgressDTOList.add(userProgressDTO);
            rank ++;
        }
        return userProgressDTOList;
    }

    public Object getUserScoreByUserId(Long userId) {
        int rank = 1;
        List<UserProgress> userList =  userProgressRepository.findAll();

        for (UserProgress userProgress : userList) {
            UserProgressDTO userProgressDTO = new UserProgressDTO(userProgress,rank);
            if(userProgress.getUser().getId().equals(userId)){
                return userProgressDTO;
            }
            rank ++;
        }
        return null;
    }


    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if(userOptional.isPresent()){
            User user1 = userOptional.get();
            user1.setName(user.getName());
            user1.setCountry(user.getCountry());
            return userRepository.save(user1);
        }
        return null;
    }
}
