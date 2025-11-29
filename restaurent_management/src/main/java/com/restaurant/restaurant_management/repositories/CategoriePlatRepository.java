package com.restaurant.restaurant_management.repositories;

import com.restaurant.restaurant_management.entities.CategoriePlat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoriePlatRepository extends JpaRepository<CategoriePlat, Long> {
    Optional<CategoriePlat> findByNom(String nom);
}