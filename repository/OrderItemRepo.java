package com.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.miniproject.entity.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {
	

}
