package com.restaurant.restaurant_management.repositories;

import com.restaurant.restaurant_management.entities.Commande;
import com.restaurant.restaurant_management.entities.Commande.StatutCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByStatut(StatutCommande statut);
    List<Commande> findByTableId(Long tableId);
}