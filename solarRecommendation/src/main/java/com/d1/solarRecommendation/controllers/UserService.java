package com.d1.solarRecommendation.controllers;


import com.d1.solarRecommendation.entities.User;
import com.d1.solarRecommendation.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> allUsers(){
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }



}
