package com.exercise.sibs.controller;


import com.exercise.sibs.entity.StockMovement;
import com.exercise.sibs.repository.StockMovementRepository;
import com.exercise.sibs.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;
    @Autowired
    private StockMovementRepository repo;

    @GetMapping public List<StockMovement> all() { return repo.findAll(); }
    @PostMapping public StockMovement create(@RequestBody StockMovement s) { return stockService.createStockMovement(s); }
    @GetMapping("/{id}") public StockMovement get(@PathVariable Long id) { return repo.findById(id).orElse(null); }

}
