package com.miniproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miniproject.entity.Order;
import com.miniproject.entity.Product;

public interface OrderRepo extends JpaRepository<Order, Integer> {
	
//	@Query("SELECT c from Category c WHERE (:categoryName is null or c.categoryName like '%:categoryName%')")
//	Page<Order> findByNameContaining(String orderName, Pageable pageable);
	
	//int countByOrderId(int orderId);
	
	//int countByOrderNameAndOrderIdNot(String orderName, int orderId);


}
