package com.exercise.sibs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "stocks")
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    private int quantity;

    @OneToMany(mappedBy = "stockMovement")
    @JsonBackReference
    private List<OrderStock> orderLinks;

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderStock> getOrderLinks() {
        return orderLinks;
    }

    public void setOrderLinks(List<OrderStock> orderLinks) {
        this.orderLinks = orderLinks;
    }
}
