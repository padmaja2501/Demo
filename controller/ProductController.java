package com.miniproject.controller;

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

import com.miniproject.entity.Product;
import com.miniproject.model.ProductDTO;
import com.miniproject.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductService productService;

	
	 @GetMapping("/products") public Page<Product>
	 getProduct(@RequestParam(required = false) String name, Pageable pageable) {
	 System.out.println("get all categories...."); return
	 productService.findByNameContaining(name, pageable); }
	
	
	@PostMapping("/products") public ProductDTO createProduct(@RequestBody @Valid
	 ProductDTO product) { return productService.save(product); }
	/*
	 * @GetMapping("/products/{id}") public Product
	 * getProductById(@PathVariable("id") int id) { return
	 * productService.findById(id); }
	 * 
	 * @PostMapping("/products") public ProductDTO createProduct(@RequestBody @Valid
	 * ProductDTO product) { return productService.save(product); }
	 * 
	 * @PutMapping("/products/{id}") public Product
	 * updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
	 * product.setProductId(id); return productService.update(product); }
	 * 
	 * @DeleteMapping("/products/{id}") public ResponseEntity<String>
	 * deleteProduct(@PathVariable("id") int id) { return new
	 * ResponseEntity<>(productService.deleteById(id), HttpStatus.OK); }
	 */
	
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return productService.findById(id);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") int id) {
		return new ResponseEntity<>(productService.deleteById(id), HttpStatus.OK);
	}
}

