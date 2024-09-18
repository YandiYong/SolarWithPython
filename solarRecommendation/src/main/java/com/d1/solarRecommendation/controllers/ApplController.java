package com.d1.solarRecommendation.controllers;


import com.d1.solarRecommendation.entities.Appliances;
import com.d1.solarRecommendation.entities.User;
import com.d1.solarRecommendation.repositories.AppRepo;
import com.d1.solarRecommendation.repositories.UserRepository;
import com.d1.solarRecommendation.services.ApplService;
import com.d1.solarRecommendation.services.dtos.ApplDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/addAppl")
@CrossOrigin(origins = "localhost:4200/**", allowedHeaders = "*")
public class ApplController {

    @Autowired
    private ApplService applService;

    @Autowired
    AppRepo appRepo;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<Appliances> getAllAppls(){
        return applService.getAllAppl();
    }

//    @PostMapping
//    public void createOrgProfile(@RequestBody Appliances appliances, @RequestParam Long id) {
//
//        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("User not found"));
//
//
//
//
//        // Associate the product with the user
//        appliances.setUser(user);
//
//
//        applService.saveAppl(appliances, id);
//    }


    @PostMapping("/addApp")
    public ResponseEntity<Appliances> createOrgProfile(@RequestBody ApplDto applDto, @RequestParam Long userId){

        User user = userRepository.findById(userId).orElseThrow(()-> new EntityNotFoundException("Does not exist"));


        Appliances app = new Appliances();

        app.setLoadName(applDto.getLoadName());
        app.setLoadPower(applDto.getLoadPower());
        app.setOpHours(applDto.getOpHours());
        app.setNoOfLoad(applDto.getNoOfLoad());
        app.setEffectiveSun(applDto.getEffectiveSun());
        app.setUser(user);

        applService.saveAppl(app,applDto.getUserId());
        System.out.println("User loggedIn: " + user);
        return  ResponseEntity.ok(app);
    }



}
