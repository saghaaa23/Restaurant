package com.restaurant.restaurant_management.repositories;

import com.restaurant.restaurant_management.entities.TableResto;
import com.restaurant.restaurant_management.entities.TableResto.StatutTable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TableRepository extends JpaRepository<TableResto, Long> {
    List<TableResto> findByStatut(StatutTable statut);
}