package com.onlinestore.api.service;

import com.onlinestore.api.modele.Laptops;
import com.onlinestore.api.repository.LaptopsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LaptopsServiceImpl implements LaptopsService {

    private final LaptopsRepository laptopsRepository;

    @Override
    public Laptops creer(Laptops laptops) {
        return laptopsRepository.save(laptops);
    }

    @Override
    public List<Laptops> lire() {
        return laptopsRepository.findAll();
    }

    @Override
    public Laptops modifier(Long id, Laptops laptops) {
        return laptopsRepository.findById(id)
                .map(p-> {
                    p.setPrix(laptops.getPrix());
                    p.setName(laptops.getName());
                    p.setBrand(laptops.getBrand());
                    return laptopsRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Laptops non trouve !"));
    }

    @Override
    public Laptops modifierQte(Long id, Integer qte) {
        return laptopsRepository.findById(id)
                .map(p-> {
                    p.setQte_available(p.getQte_available() - qte);
                    return laptopsRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("No such product"));
    }

    @Override
    public String supprimer(Long id) {
        laptopsRepository.deleteById(id);
        return "Deleted!";
    }
}
