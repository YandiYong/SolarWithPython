package com.d1.solarRecommendation.controllers;


import com.d1.solarRecommendation.entities.Appliances;
import com.d1.solarRecommendation.entities.User;
import com.d1.solarRecommendation.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200/**", allowCredentials = "true")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService =userService;
    }

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }



    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        User saveUser = userService.addApp(user);
        return ResponseEntity.ok(saveUser);
    }


    @GetMapping("/")
    public ResponseEntity<List<User>> allUsers() {
        List <User> users = userService.allUsers();

        return ResponseEntity.ok(users);
    }
}
