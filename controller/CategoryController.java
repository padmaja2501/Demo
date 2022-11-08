package com.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.entity.Category;
import com.miniproject.model.CategoryDTO;
import com.miniproject.service.CategoryService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	@GetMapping("/categorys")
	public Page<Category> getAllCategory(@RequestParam(required = false) String name, Pageable pageable) {
		System.out.println("get all categories....");
		return categoryService.findByNameContaining(name, pageable);
	}

	@GetMapping("/categorys/{id}")
	public Category getCategoryById(@PathVariable("id") int id) {
		return categoryService.findById(id);
	}

	@PostMapping("/categorys")
	public CategoryDTO createCategory(@RequestBody @Valid CategoryDTO category) {
		return categoryService.save(category);
	}

	@PutMapping("/categorys/{id}")
	public Category updateCategory(@PathVariable("id") int id, @RequestBody Category category) {
		category.setId(id);
		return categoryService.update(category);
	}

	@DeleteMapping("/categorys/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") int id) {
		return new ResponseEntity<>(categoryService.deleteById(id), HttpStatus.OK); 
	}
//
//	@DeleteMapping("/categorys")
//	public ResponseEntity<String> deleteAllCategorys() {
//		try {
//			int numRows = categoryService.deleteAll();
//			return new ResponseEntity<>("Deleted " + numRows + " Categorys(s) successfully.", HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>("Cannot delete categorys.", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}
}