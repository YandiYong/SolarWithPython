package com.d1.solarRecommendation.configs;


import com.d1.solarRecommendation.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    /*TODO:Authentication middleware
       For every request, we want to retrieve the JWT token in the header “Authorization”, and validate it
         */
     private final HandlerExceptionResolver handlerExceptionResolver;
     private final JwtService jwtService;
     private final UserDetailsService userDetailsService;

     public JwtAuthenticationFilter(JwtService jwtService,UserDetailsService userDetailsService,HandlerExceptionResolver handlerExceptionResolver){
         this.jwtService = jwtService;
         this.userDetailsService = userDetailsService;
         this.handlerExceptionResolver = handlerExceptionResolver;
     }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {

         final String authHeader = request.getHeader("Authorization");

         if(authHeader == null || !authHeader.startsWith("Bearer ")){
             filterChain.doFilter(request,response);
             return;
         }//endIf
        try {
            final String jwt = authHeader.substring(7);
            final String userEmail = jwtService.extractUsername(jwt);
        }
    }



}
