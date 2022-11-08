package com.miniproject.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.miniproject.entity.Category;
import com.miniproject.model.CategoryDTO;

public interface CategoryService {
	CategoryDTO save(CategoryDTO category);

	Category update(Category category);

	Category findById(int id);

	String deleteById(int id);

//	List<Category> findAll();
//
//	int insert(Category category);

	Page<Category> findByNameContaining(String name, Pageable pageable);

//	int deleteAll();
}
