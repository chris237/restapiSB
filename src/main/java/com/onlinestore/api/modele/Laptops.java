package com.onlinestore.api.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "PRODUIT")
@Getter
@Setter
@NoArgsConstructor
public class Laptops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;

    @Column(name = "prix")
    private BigDecimal prix;
    private Integer qte_available;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Brand brand;
}
