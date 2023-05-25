package com.onlinestore.api.service;

import com.onlinestore.api.modele.Orders;

import java.util.List;

public interface OrdersService {

    Orders creer(Orders orders);

    List<Orders> lire();

    Orders modifier(Long id, Orders orders);

    String supprimer(Long id);
}
