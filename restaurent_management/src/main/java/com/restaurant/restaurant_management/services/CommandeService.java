package com.restaurant.restaurant_management.services;

import com.restaurant.restaurant_management.entities.*;
import com.restaurant.restaurant_management.entities.Commande.StatutCommande;
import com.restaurant.restaurant_management.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandeService {

    private final CommandeRepository commandeRepository;
    private final TableRepository tableRepository;
    private final PlatRepository platRepository;

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée"));
    }

    public List<Commande> getCommandesByStatut(StatutCommande statut) {
        return commandeRepository.findByStatut(statut);
    }

    public List<Commande> getCommandesByTable(Long tableId) {
        return commandeRepository.findByTableId(tableId);
    }

    public Commande createCommande(Commande commande) {
        if (commande.getTable() != null && commande.getTable().getId() != null) {
            TableResto table = tableRepository.findById(commande.getTable().getId())
                    .orElseThrow(() -> new RuntimeException("Table non trouvée"));
            commande.setTable(table);
        }



        return commandeRepository.save(commande);
    }

    public Commande updateStatut(Long id, StatutCommande statut) {
        Commande commande = getCommandeById(id);
        commande.setStatut(statut);
        return commandeRepository.save(commande);
    }

    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}