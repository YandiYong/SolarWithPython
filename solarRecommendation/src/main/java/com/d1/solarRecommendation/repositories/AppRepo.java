package com.d1.solarRecommendation.repositories;

import com.d1.solarRecommendation.entities.Appliances;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppRepo extends JpaRepository<Appliances,Long> {

}
