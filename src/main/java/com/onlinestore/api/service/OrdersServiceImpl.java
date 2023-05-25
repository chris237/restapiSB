package com.onlinestore.api.service;

import com.onlinestore.api.controller.SendController;
import com.onlinestore.api.modele.Line;
import com.onlinestore.api.modele.Orders;
import com.onlinestore.api.repository.OrdersRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;

@Service
@AllArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    private LaptopsServiceImpl laptopsServiceImp;

    private SendController sendController;


    @Override
    @Transactional
    public Orders creer(@NotNull Orders orders) {
        for (Line line : orders.getLines()) {
            laptopsServiceImp.modifierQte(line.getLaptops().getId(), line.getQte());
        }
        sendController.sendEmail(orders.getEmail(),"Achat effectuer par "+ orders.getName_cust(),"Dear " + orders.getName_cust() + " \n" + orders );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("\"http://example.cm/facturation\""))
                .POST(HttpRequest.BodyPublishers.ofString(orders.toString()))
                .build();
        return ordersRepository.save(orders);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Orders> lire() {
        return ordersRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Orders modifier(Long id, Orders orders) {
        return ordersRepository.findById(id)
                .map(p-> {
                    p.setName_cust(orders.getName_cust());
                    p.setEmail(orders.getEmail());
                    p.setOrderdate(orders.getOrderdate());
                    return ordersRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Orders not found"));
    }

    @Override
    public String supprimer(Long id) {
        ordersRepository.deleteById(id);
        return "Deleted";
    }
}
