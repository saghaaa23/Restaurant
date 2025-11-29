package com.restaurant.restaurant_management.controllers;

import com.restaurant.restaurant_management.entities.Commande;
import com.restaurant.restaurant_management.entities.Commande.StatutCommande;
import com.restaurant.restaurant_management.services.CommandeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/commandes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Commandes")
public class CommandeController {

    private final CommandeService commandeService;

    @GetMapping
    public ResponseEntity<List<Commande>> getAllCommandes() {
        return ResponseEntity.ok(commandeService.getAllCommandes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        return ResponseEntity.ok(commandeService.getCommandeById(id));
    }

    @GetMapping("/statut/{statut}")
    public ResponseEntity<List<Commande>> getCommandesByStatut(@PathVariable StatutCommande statut) {
        return ResponseEntity.ok(commandeService.getCommandesByStatut(statut));
    }

    @GetMapping("/table/{tableId}")
    public ResponseEntity<List<Commande>> getCommandesByTable(@PathVariable Long tableId) {
        return ResponseEntity.ok(commandeService.getCommandesByTable(tableId));
    }

    @PostMapping
    public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) {
        return ResponseEntity.ok(commandeService.createCommande(commande));
    }

    @PatchMapping("/{id}/statut")
    public ResponseEntity<Commande> updateStatut(@PathVariable Long id, @RequestParam StatutCommande statut) {
        return ResponseEntity.ok(commandeService.updateStatut(id, statut));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
        return ResponseEntity.noContent().build();
    }
}