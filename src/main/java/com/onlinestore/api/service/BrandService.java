package com.onlinestore.api.service;

import com.onlinestore.api.modele.Brand;

import java.util.List;

public interface BrandService {

    Brand creer(Brand brand);

    List<Brand> lire();

    Brand modifier(Long id, Brand brand);

    String supprimer(Long id);
}
