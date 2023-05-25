package com.onlinestore.api.controller;

import com.onlinestore.api.modele.Orders;
import com.onlinestore.api.service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/online-store/api/purchase/")
@AllArgsConstructor
public class OnlineControlleur {

    private final OrdersService ordersService;

    @PostMapping("")
    public Orders create(@RequestBody Orders orders){
        return ordersService.creer(orders);
    }

    @GetMapping("")
    public List<Orders> read(){
        return ordersService.lire();
    }

    @PutMapping("/{id}")
    public Orders update(@PathVariable Long id, @RequestBody Orders orders){
        return  ordersService.modifier(id, orders);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return ordersService.supprimer(id);
    }
}
