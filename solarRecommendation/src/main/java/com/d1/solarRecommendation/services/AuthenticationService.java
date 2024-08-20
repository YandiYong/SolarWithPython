package com.d1.solarRecommendation.services;

import com.d1.solarRecommendation.auth.AuthenticationResponse;
import com.d1.solarRecommendation.entities.User;
import com.d1.solarRecommendation.repositories.UserRepository;
import com.d1.solarRecommendation.services.dtos.LoginUserDto;
import com.d1.solarRecommendation.services.dtos.RegisterUserDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationResponse signup(RegisterUserDto input) {
        User user = new User();
        user.setFullName(input.getFullName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

         userRepository.save(user);
        var jwtToken = jwtService.generateToken(user, user.getId());

        return  AuthenticationResponse.builder()
                .token(jwtToken)
                .message("Registered Successful")
                .status("OK")
                .build();
    }

    public AuthenticationResponse authenticate(LoginUserDto input) {
        //TODO: Handles the process of verifying user credentials
        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));
        var user = userRepository.findByEmail(input.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user, user.getId());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .message("Login Successful")
                .status("OK")
                .build();
       // return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }


}
