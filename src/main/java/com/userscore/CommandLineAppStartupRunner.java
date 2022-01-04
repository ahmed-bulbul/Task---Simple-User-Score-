package com.userscore;

import com.userscore.userScore.entity.User;
import com.userscore.userScore.entity.UserProgress;
import com.userscore.userScore.entity.UserProgressDTO;
import com.userscore.userScore.repository.UserProgressRepository;
import com.userscore.userScore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserProgressRepository userProgressRepository;

    public void addData(){
        User tamim = new User();
        tamim.setName("Tamim");
        tamim.setCountry("Bangladesh");
        userRepository.save(tamim);

        User sakib = new User();
        sakib.setName("Sakib");
        sakib.setCountry("Bangladesh");
        userRepository.save(sakib);

        User mashrafi = new User();
        mashrafi.setName("Mashrafi");
        mashrafi.setCountry("Bangladesh");
        userRepository.save(mashrafi);

        User musfiqur = new User();
        musfiqur.setName("Musfiqur");
        musfiqur.setCountry("Bangladesh");
        userRepository.save(musfiqur);


        UserProgress tamimProgress = new UserProgress();
        tamimProgress.setUser(tamim);
        tamimProgress.setLevel(5);
        tamimProgress.setScore(100F);
        userProgressRepository.save(tamimProgress);


        UserProgress sakibProgress = new UserProgress();
        sakibProgress.setUser(sakib);
        sakibProgress.setLevel(3);
        sakibProgress.setScore(70F);
        userProgressRepository.save(sakibProgress);


        UserProgress mashrafiProgress = new UserProgress();
        mashrafiProgress.setUser(mashrafi);
        mashrafiProgress.setLevel(4);
        mashrafiProgress.setScore(65F);
        userProgressRepository.save(mashrafiProgress);


        UserProgress musfiqurProgress = new UserProgress();
        musfiqurProgress.setUser(musfiqur);
        musfiqurProgress.setLevel(5);
        musfiqurProgress.setScore(45F);
        userProgressRepository.save(musfiqurProgress);

    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineAppStartupRunner.run()");

        User user = userRepository.findByName("Tamim");
        if (user == null) {
            addData();
        }

    }
}
