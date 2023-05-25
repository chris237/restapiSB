package com.onlinestore.api.controller;

import com.onlinestore.api.modele.Laptops;
import com.onlinestore.api.service.LaptopsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
@AllArgsConstructor
public class LaptopsController {

    private final LaptopsService laptopsService;

    @PostMapping("/create")
    public Laptops create(@RequestBody Laptops laptops){
        return laptopsService.creer(laptops);
    }

    @GetMapping("read")
    public List<Laptops> read(){
        return laptopsService.lire();
    }

    @PutMapping("/update/{id}")
    public Laptops update(@PathVariable Long id, @RequestBody Laptops laptops){
        return laptopsService.modifier(id, laptops);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return laptopsService.supprimer(id);
    }
}
