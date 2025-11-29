package com.restaurant.restaurant_management.services;

import com.restaurant.restaurant_management.entities.Plat;
import com.restaurant.restaurant_management.entities.CategoriePlat;
import com.restaurant.restaurant_management.repositories.PlatRepository;
import com.restaurant.restaurant_management.repositories.CategoriePlatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PlatService {

    private final PlatRepository platRepository;
    private final CategoriePlatRepository categoriePlatRepository;

    public List<Plat> getAllPlats() {
        return platRepository.findAll();
    }

    public Plat getPlatById(Long id) {
        return platRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plat non trouvé"));
    }

    public List<Plat> getPlatsByCategorie(Long categorieId) {
        return platRepository.findByCategorieId(categorieId);
    }

    public List<Plat> getPlatsDisponibles() {
        return platRepository.findByDisponible(true);
    }

    public Plat createPlat(Plat plat) {
        if (plat.getCategorie() != null && plat.getCategorie().getId() != null) {
            CategoriePlat categorie = categoriePlatRepository.findById(plat.getCategorie().getId())
                    .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
            plat.setCategorie(categorie);
        }
        return platRepository.save(plat);
    }

    public Plat updatePlat(Long id, Plat platDetails) {
        Plat plat = getPlatById(id);
        plat.setNom(platDetails.getNom());
        plat.setDescription(platDetails.getDescription());
        plat.setPrix(platDetails.getPrix());
        plat.setDisponible(platDetails.getDisponible());

        if (platDetails.getCategorie() != null && platDetails.getCategorie().getId() != null) {
            CategoriePlat categorie = categoriePlatRepository.findById(platDetails.getCategorie().getId())
                    .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
            plat.setCategorie(categorie);
        }

        return platRepository.save(plat);
    }

    public Plat updateDisponibilite(Long id, Boolean disponible) {
        Plat plat = getPlatById(id);
        plat.setDisponible(disponible);
        return platRepository.save(plat);
    }

    public void deletePlat(Long id) {
        platRepository.deleteById(id);
    }
}