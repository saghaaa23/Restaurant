package com.restaurant.restaurant_management.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "commandes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private TableResto table;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private StatutCommande statut;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommandePlat> commandePlats = new ArrayList<>();

    public enum StatutCommande {
        EN_ATTENTE, EN_PREPARATION, PRETE, SERVIE, ANNULEE
    }

    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
        if (this.statut == null) {
            this.statut = StatutCommande.EN_ATTENTE;
        }
    }
}