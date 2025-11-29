package com.restaurant.restaurant_management.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "plats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nom;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull
    @DecimalMin("0.01")
    @Column(nullable = false)
    private Double prix;

    @Column(nullable = false)
    private Boolean disponible = true;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private CategoriePlat categorie;
}