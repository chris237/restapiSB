package com.onlinestore.api.controller;

import com.onlinestore.api.modele.Brand;
import com.onlinestore.api.modele.Memory;
import com.onlinestore.api.service.MemoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memory")
@AllArgsConstructor
public class MemoryController {

    private final MemoryService memoryService;
    @PostMapping("create")
    public Memory create(@RequestBody Memory RAMMemoryCard){
        return memoryService.creer(RAMMemoryCard);
    }

    @GetMapping("/read")
    public List<Memory> read() {
        return memoryService.lire();
    }

    @GetMapping("/getmemorybyModel/{id}")
    public List<Memory> getbymodelid(Brand brand){
        return memoryService.getByBrandID(brand);
    }

    @PutMapping("/update/{id}")
    public Memory update(@PathVariable Long id, @RequestBody Memory RAMMemoryCard){
        return memoryService.modifier(id, RAMMemoryCard);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return memoryService.supprimer(id);
    }
}
