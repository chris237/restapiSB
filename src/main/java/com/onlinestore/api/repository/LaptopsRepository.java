package com.onlinestore.api.repository;

import com.onlinestore.api.modele.Laptops;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopsRepository extends JpaRepository<Laptops, Long> {
}
