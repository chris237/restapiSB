package com.onlinestore.api.repository;

import com.onlinestore.api.modele.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
