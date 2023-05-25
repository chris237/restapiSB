package com.onlinestore.api.controller;

import com.onlinestore.api.modele.Brand;
import com.onlinestore.api.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@AllArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping("")
    public Brand create(@RequestBody Brand brand){
        return brandService.creer(brand);
    }

    @GetMapping("")
    public List<Brand> read() {
        return brandService.lire();
    }

    @PutMapping("/{id}")
    public Brand upadate(@PathVariable Long id, @RequestBody Brand brand) {
        return brandService.modifier(id, brand);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return brandService.supprimer(id);
    }
}
