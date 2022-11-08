package com.miniproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.miniproject.entity.Product;
@Repository

public interface ProdRepo extends JpaRepository<Product, Integer> {

	@Query("SELECT p from Product p WHERE (:productName is null or p.productName like '%:productName%')")
	Page<Product> findByNameContaining(String productName, Pageable pageable);
	
	/*
	 * int countByProductName(String productName);
	 * 
	 * int countByProductNameAndProductIdNot(int productId, String productName);
	 * 
	 * //int countByCategoryNameAndCategoryIdNot(int productId, String productName);
	 * 
	 
	
	
	int countByProductName(String productName);
	
	/*
	 * @Query(value = "SELECT * from products WHERE n LIKE '%" + name + "%'")
	 * List<Product> findByNameContaining(String name);
	 */
	
	/*
	 * @Query("SELECT FROM products WHERE id=?") Product findById(int id);
	 */
	
	//List<Product> findById(int id);
	
	int countByProductName(String productName);
	
	int countByProductNameAndIdNot(int id, String productName);
	
//	Optional <Product> findById(int id);
//
//	void update(Product loaded);
}
