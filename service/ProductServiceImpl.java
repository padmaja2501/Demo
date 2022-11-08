package com.miniproject.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.miniproject.entity.Product;
import com.miniproject.model.ProductDTO;
import com.miniproject.repository.ProdRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProdRepo prodRepo;

	/*
	 * @Override public ProductDTO save(ProductDTO payload) { // name validation int
	 * count = prodRepo.countByProductName(payload.getProductName()); if(count > 0)
	 * { throw new RuntimeException("Product's name existed."); }
	 * 
	 * Product product = prodRepo.save(new Product(payload));
	 * 
	 * return new ProductDTO(product); }
	 * 
	 * @Override public Product update(Product product) { Product loaded =
	 * prodRepo.findById(product.getProductId()).orElseThrow(()->new
	 * RuntimeException("Product's ID not found."));
	 * 
	 * //Name validation int count =
	 * prodRepo.countByProductNameAndProductIdNot(product.getProductId(),
	 * product.getProductName()); if(count > 0) { throw new
	 * RuntimeException("Product's name existed."); }
	 * 
	 * BeanUtils.copyProperties(product, loaded); return prodRepo.save(loaded); }
	 * 
	 * @Override public Product findById(int id) { return
	 * prodRepo.findById(id).orElseThrow(()->new
	 * RuntimeException("Product's ID not found.")); }
	 * 
	 * @Override public String deleteById(int id) { Product loaded =
	 * prodRepo.findById(id).orElseThrow(()->new
	 * RuntimeException("Product's ID not found."));
	 * 
	 * prodRepo.delete(loaded); return "Successfully deleted."; }
	 */

	@Override
	public Page<Product> findByNameContaining(String name, Pageable pageable) {
		System.err.println("search...");
		return prodRepo.findByNameContaining(name, pageable);
	}

	@Override
	public String deleteById(int id) {
		Product loaded = prodRepo.findById(id).orElseThrow(() -> new RuntimeException("Product's ID not found."));

		prodRepo.delete(loaded);
		return "Successfully deleted.";
	}

	@Override
	public Product findById(int id) {
		return prodRepo.findById(id).orElseThrow(() -> new RuntimeException("Product's ID not found."));
	}

	@Override 
	public Product update(Product product) { 
		return prodRepo.findById(product.getId()).orElseThrow(()->new RuntimeException("Product's ID not found."));
				
	}
			
			 
	/*
	 * @GetMapping("/products/{id}") public ResponseEntity<Product>
	 * getUsersById(@PathVariable(value = "id") int id) throws
	 * ResourceNotFoundException { Product product = prodRepo.findById(id)
	 * .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " +
	 * id)); return ResponseEntity.ok().body(product); }
	 */

	/*
	 * public Product findById(int id) { return
	 * prodRepo.findById(id).orElseThrow(()->new
	 * RuntimeException("Product's ID not found.")); }
	 */

	@Override
	public ProductDTO save(ProductDTO payload) { // name validation int
		int count = prodRepo.countByProductName(payload.getProductName());
		if (count > 0) {
			throw new RuntimeException("Product's name existed.");
		}

		Product product = prodRepo.save(new Product(payload));
		return new ProductDTO(product);
	}

	// @PostConstruct
	void test() {
		// database initiase
//		Category category = Category.builder().categoryName(new Date().toGMTString()).build();
//		save(category);
	}

}
