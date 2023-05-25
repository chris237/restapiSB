package com.onlinestore.api.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "RAM_Memory_Card")
@Getter
@Setter
@NoArgsConstructor
public class Memory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "model_ids")
    private Set<Brand> brands = new HashSet<>();

    public Boolean getbybrand(Brand bran){
        if ((this.getBrands() != null) && (this.getBrands().size() > 0)){
            for (Brand brand : this.getBrands()) {
                if (brand.equals(bran)){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
}
