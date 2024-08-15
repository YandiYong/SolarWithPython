package com.d1.solarRecommendation.services.dtos;

import lombok.Data;

@Data
public class AddApplDto {

    private String loadName;
    private Integer loadPower;
    private  Integer opHours;
    private Integer noOfLoad;
    private  Integer effectiveSun;
    private Long userId;

}
