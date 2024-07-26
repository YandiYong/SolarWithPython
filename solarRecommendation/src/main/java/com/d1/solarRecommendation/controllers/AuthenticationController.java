package com.d1.solarRecommendation.controllers;

import com.d1.solarRecommendation.entities.User;
import com.d1.solarRecommendation.services.AuthenticationService;
import com.d1.solarRecommendation.services.JwtService;
import com.d1.solarRecommendation.services.dtos.LoginUserDto;
import com.d1.solarRecommendation.services.dtos.RegisterUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService,AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto){
        User registerUser = authenticationService.signup(registerUserDto);
        return  ResponseEntity.ok(registerUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto){
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

       LoginResponse loginResponse = new LoginResponse();
       loginResponse.setToken(jwtToken);
       loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

}
