package com.restaurant.restaurant_management.services;

import com.restaurant.restaurant_management.entities.CategoriePlat;
import com.restaurant.restaurant_management.repositories.CategoriePlatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoriePlatService {

    private final CategoriePlatRepository categoriePlatRepository;

    public List<CategoriePlat> getAllCategories() {
        return categoriePlatRepository.findAll();
    }

    public CategoriePlat getCategorieById(Long id) {
        return categoriePlatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
    }

    public CategoriePlat createCategorie(CategoriePlat categorie) {
        return categoriePlatRepository.save(categorie);
    }

    public void deleteCategorie(Long id) {
        categoriePlatRepository.deleteById(id);
    }
}