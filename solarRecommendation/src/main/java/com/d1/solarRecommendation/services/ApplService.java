package com.d1.solarRecommendation.services;

import com.d1.solarRecommendation.entities.Appliances;

import java.util.List;

public interface ApplService {

    List<Appliances> getAllAppl();

    void saveAppl(Appliances appliances, Long id);
    void applUpDate(Long id, Appliances appliances);
    Appliances getApplById(Long id);
    void  deleteAppl(Long id);

}
