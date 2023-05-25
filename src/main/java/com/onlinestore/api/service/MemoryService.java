package com.onlinestore.api.service;

import com.onlinestore.api.modele.Brand;
import com.onlinestore.api.modele.Memory;

import java.util.List;

public interface MemoryService {

    Memory creer(Memory RAMMemoryCard);

    List<Memory> lire();

    List<Memory> getByBrandID(Brand brand);

    Memory modifier(Long id, Memory RAMMemoryCard);

    String supprimer(Long id);
}
