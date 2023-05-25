package com.onlinestore.api.service;

import com.onlinestore.api.modele.Laptops;

import java.util.List;

public interface LaptopsService {

    Laptops creer(Laptops laptops);

    List<Laptops> lire();

    Laptops modifier(Long id, Laptops laptops);

    Laptops modifierQte(Long id, Integer qte);

    String supprimer(Long id);

}
