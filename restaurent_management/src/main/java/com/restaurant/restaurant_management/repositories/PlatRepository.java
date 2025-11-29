package com.restaurant.restaurant_management.repositories;

import com.restaurant.restaurant_management.entities.Plat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlatRepository extends JpaRepository<Plat, Long> {
    List<Plat> findByCategorieId(Long categorieId);
    List<Plat> findByDisponible(Boolean disponible);
}