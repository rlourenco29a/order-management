package com.exercise.sibs.service;

import com.exercise.sibs.entity.Order;
import com.exercise.sibs.entity.StockMovement;
import com.exercise.sibs.repository.OrderRepository;
import com.exercise.sibs.repository.StockMovementRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StockService {

    private static final Logger logger = LogManager.getLogger(StockService.class);

    @Autowired
    private StockMovementRepository stockRepo;
    @Autowired private OrderRepository orderRepo;
    @Autowired private OrderService orderService;

    @Transactional
    public StockMovement createStockMovement(StockMovement movement) {
        stockRepo.save(movement);
        logger.info("Stock movement created: {}", movement.getId());

        List<Order> orders = orderRepo.findAll();
        for (Order order : orders) {
            if (!order.isCompleted() && order.getItem().getId().equals(movement.getItem().getId())) {
                orderService.fulfillOrder(order);
            }
        }
        return movement;
    }

}
