package com.exercise.sibs.controller;

import com.exercise.sibs.entity.Order;
import com.exercise.sibs.repository.OrderRepository;
import com.exercise.sibs.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepo;

    @GetMapping
    public List<Order> all() { return orderRepo.findAll(); }
    @PostMapping
    public Order create(@RequestBody Order o) { return orderService.createOrder(o); }
    @GetMapping("/{id}")
    public Order get(@PathVariable Long id) { return orderRepo.findById(id).orElse(null); }
}
