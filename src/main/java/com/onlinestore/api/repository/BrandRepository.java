package com.onlinestore.api.repository;

import com.onlinestore.api.modele.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
