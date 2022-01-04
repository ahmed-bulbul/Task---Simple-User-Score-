package com.userscore.userScore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProgressDTO {
    private Integer rank;
    private Integer level;
    private String name;
    private Float score;


    public UserProgressDTO(UserProgress userProgress, int rank) {
        this.rank = rank;
        this.level = userProgress.getLevel();
        this.name = userProgress.getUser().getName();
        this.score = userProgress.getScore();

    }
}
