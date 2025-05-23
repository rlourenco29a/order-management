package com.exercise.sibs.repository;

import com.exercise.sibs.entity.OrderStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStockRepository extends JpaRepository<OrderStock, Long> {
}
