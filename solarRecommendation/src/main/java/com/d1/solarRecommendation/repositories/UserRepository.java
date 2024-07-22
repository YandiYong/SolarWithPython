package com.d1.solarRecommendation.repositories;

import com.d1.solarRecommendation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);//TODO: To be implemented for user authentication
}
