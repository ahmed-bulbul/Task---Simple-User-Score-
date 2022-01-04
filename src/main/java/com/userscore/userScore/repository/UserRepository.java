package com.userscore.userScore.repository;

import com.userscore.userScore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends JpaRepository<User, Long> {


    User findByName(String tamim);
}
