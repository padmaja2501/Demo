package com.miniproject.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.miniproject.entity.Product;
import com.miniproject.model.ProductDTO;

public interface ProductService {
	/*
	 * ProductDTO save(ProductDTO product);
	 * 
	 * Product update(Product product);
	 * 
	 
	 * 
	 * String deleteById(int id);
	 */
//	List<Category> findAll();
//
//	int insert(Category category);

	Page<Product> findByNameContaining(String name, Pageable pageable);
	
	ProductDTO save(ProductDTO product);

	Object deleteById(int id);

	Product findById(int id);

	Product update(Product product);

	//Product findById(int id);
	
	//Product findById(int id);
	

//	int deleteAll();
}

