package com.exercise.sibs.repository;

import com.exercise.sibs.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
