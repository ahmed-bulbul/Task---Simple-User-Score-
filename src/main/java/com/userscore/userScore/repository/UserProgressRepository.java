package com.userscore.userScore.repository;

import com.userscore.userScore.entity.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProgressRepository extends JpaRepository<UserProgress, Long> {

    //    @Query(value = "SELECT * FROM user_progress ORDER BY score DESC LIMIT 10", nativeQuery = true)
    List<UserProgress> findFirst10ByOrderByScoreDesc();

}
