package com.exercise.sibs.service;

import com.exercise.sibs.entity.Order;
import com.exercise.sibs.entity.OrderStock;
import com.exercise.sibs.entity.StockMovement;
import com.exercise.sibs.repository.OrderRepository;
import com.exercise.sibs.repository.OrderStockRepository;
import com.exercise.sibs.repository.StockMovementRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    private static final Logger logger = LogManager.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private StockMovementRepository stockRepo;
    @Autowired
    private OrderStockRepository orderStockRepository;
    @Autowired
    private JavaMailSender mailSender;

    @Transactional
    public Order createOrder(Order order) {
        orderRepo.save(order);
        fulfillOrder(order);
        return order;
    }

    @Transactional
    public void fulfillOrder(Order order) {
        List<StockMovement> stocks = stockRepo.findAll();
        int remaining = order.getQuantity() - order.getFulfilledQuantity();

        for (StockMovement stock : stocks) {
            if (!stock.getItem().getId().equals(order.getItem().getId())) continue;
            int usable = stock.getQuantity();
            if (usable <= 0) continue;

            int used = Math.min(remaining, usable);
            stock.setQuantity(usable - used);
            order.setFulfilledQuantity(order.getFulfilledQuantity() + used);
            orderStockRepository.save(new OrderStock(order, stock, used));
            remaining -= used;
            if (remaining == 0) break;
        }

        if (order.isCompleted()) {
            sendNotification(order);
            logger.info("Order completed: {}", order.getId());
        }
    }

    private void sendNotification(Order order) {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(order.getUser().getEmail());
            msg.setSubject("Order Completed");
            msg.setText("Your order for " + order.getQuantity() + " x " + order.getItem().getName() + " has been completed.");
            mailSender.send(msg);
            logger.info("Email sent to {} for order {}", order.getUser().getEmail(), order.getId());
        } catch (Exception e) {
            logger.error("Error sending email for order {}", order.getId(), e);
        }
    }
}
