package com.d1.solarRecommendation.controllers;

import lombok.Data;

@Data
public class LoginResponse {

    private String token;
    private Long expiresIn;

    public  String getToken(){
        return token;
    }
}
