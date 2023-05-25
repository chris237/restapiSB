package com.onlinestore.api.service;

import com.onlinestore.api.modele.Brand;
import com.onlinestore.api.modele.Memory;
import com.onlinestore.api.repository.MemoryRespository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemoryServiceImpl implements MemoryService {

    private final MemoryRespository memoryRespository;

    @Override
    public Memory creer(Memory memory) {
        return memoryRespository.save(memory);
    }

    @Override
    public List<Memory> lire() {
        return memoryRespository.findAll();
    }

    @Override
    public List<Memory> getByBrandID(Brand brand) {
        return memoryRespository.findAll().stream()
                .filter(p -> !p.getbybrand(brand))
                .toList();
    }

    @Override
    public Memory modifier(Long id, Memory memory) {
        return memoryRespository.findById(id)
                .map(p->{
                    p.setName(memory.getName());
                    p.setBrands(memory.getBrands());
                    return memoryRespository.save(p);
                }).orElseThrow(() ->new RuntimeException("Categorie non trouve"));
    }

    @Override
    public String supprimer(Long id) {
        memoryRespository.deleteById(id);
        return "Categorie Supprime";
    }
}
