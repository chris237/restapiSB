package com.onlinestore.api.service;

import com.onlinestore.api.modele.Brand;
import com.onlinestore.api.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService{

    private final BrandRepository brandRepository;

    @Override
    public Brand creer(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> lire() {
        return brandRepository.findAll();
    }

    @Override
    public Brand modifier(Long id, Brand brand) {
        return brandRepository.findById(id)
                .map(p-> {
                    p.setName(brand.getName());
                    return brandRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Brand not Found !!!"));
    }

    @Override
    public String supprimer(Long id) {
        brandRepository.deleteById(id);
        return "Deleted !!";
    }
}
