package com.miniproject.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.miniproject.entity.Order;
import com.miniproject.entity.Product;
import com.miniproject.model.OrderDTO;
import com.miniproject.model.ProductDTO;

public interface OrderService {

	OrderDTO save(OrderDTO product);

	Object deleteById(int id);

	Order findById(int id);

	Order update(Order product);

	// List<Category> findAll(); // // int insert(Category category);

	//Page<Order> findByNameContaining(String name, Pageable pageable);

	// int deleteAll(); }
	
	//Order update(Order order);
}