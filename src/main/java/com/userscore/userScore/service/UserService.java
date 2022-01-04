package com.userscore.userScore.service;


import com.userscore.userScore.entity.UserProgress;
import com.userscore.userScore.entity.UserProgressDTO;
import com.userscore.userScore.repository.UserProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserProgressRepository userProgressRepository;



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
}
