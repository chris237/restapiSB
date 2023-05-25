package com.onlinestore.api.repository;

import com.onlinestore.api.modele.Memory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoryRespository extends JpaRepository<Memory, Long> {
}
