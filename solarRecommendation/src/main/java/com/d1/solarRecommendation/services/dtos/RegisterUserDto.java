package com.d1.solarRecommendation.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class RegisterUserDto {

    private  String email;

    private String password;

    private String fullName;


}
