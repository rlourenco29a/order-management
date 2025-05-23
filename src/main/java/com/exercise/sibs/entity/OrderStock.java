package com.exercise.sibs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "order_stock")
public class OrderStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonBackReference
    private Order order;

    @ManyToOne
    @JoinColumn(name = "stock_movement_id", nullable = false)
    @JsonBackReference
    private StockMovement stockMovement;

    @Column(name = "quantity_used", nullable = false)
    private int quantityUsed;

    public OrderStock(Order order, StockMovement stockMovement, int quantityUsed) {
        this.order = order;
        this.stockMovement = stockMovement;
        this.quantityUsed = quantityUsed;
    }

    public OrderStock() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public StockMovement getStockMovement() {
        return stockMovement;
    }

    public void setStockMovement(StockMovement stockMovement) {
        this.stockMovement = stockMovement;
    }

    public int getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(int quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

}
