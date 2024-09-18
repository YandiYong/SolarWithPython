package com.d1.solarRecommendation.repositories;

import com.d1.solarRecommendation.entities.Appliances;
import com.d1.solarRecommendation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppRepo extends JpaRepository<Appliances,Long> {

}
