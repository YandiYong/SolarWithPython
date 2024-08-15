package com.d1.solarRecommendation.services;

import com.d1.solarRecommendation.entities.Appliances;
import com.d1.solarRecommendation.entities.User;
import com.d1.solarRecommendation.repositories.AppRepo;
import com.d1.solarRecommendation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplServiceImpl implements ApplService {

    @Autowired
    AppRepo appRepo;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Appliances> getAllAppl() {
        return appRepo.findAll();
    }

    @Override
    public void saveAppl(Appliances appliances, Long id) {

        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid"));
            appRepo.save(appliances);

    }

    @Override
    public void applUpDate(Long id, Appliances appliances) {

    }

    @Override
    public Appliances getApplById(Long id) {
        return null;
    }

    @Override
    public void deleteAppl(Long id) {

    }
}
