package com.miniproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miniproject.entity.Category;

public interface CatRepo extends JpaRepository<Category, Integer> {

	@Query("SELECT c from Category c WHERE (:categoryName is null or c.categoryName like '%:categoryName%')")
	Page<Category> findByNameContaining(String categoryName, Pageable pageable);
	
	int countByCategoryName(String categoryName);
	
	int countByCategoryNameAndIdNot(String categoryName, int id);
	
}
