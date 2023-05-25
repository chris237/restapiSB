package com.onlinestore.api.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "line")
@Getter
@Setter
@NoArgsConstructor
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "orders_id")
//    private Orders orders;

    @OneToOne
    @JoinColumn(name = "laptop_id")
    private Laptops laptops;

    @Column(name = "quantity")
    private Integer qte;

}
