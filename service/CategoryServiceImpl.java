package com.miniproject.service;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.miniproject.entity.Category;
import com.miniproject.model.CategoryDTO;
import com.miniproject.repository.CatRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CatRepo catRepo;

	@Override
	public CategoryDTO save(CategoryDTO payload) {
		// name validation
		int count = catRepo.countByCategoryName(payload.getCategoryName());
		if(count > 0) {
			throw new RuntimeException("Category's name existed.");
		}
		
		Category category = catRepo.save(new Category(payload));
		
		return new CategoryDTO(category);
	}

	@Override
	public Category update(Category product) {
		Category loaded = catRepo.findById(product.getId()).orElseThrow(()->new RuntimeException("Category's ID not found."));
		
		//Name validation
//		int count = catRepo.countByCategoryNameAndCategoryIdNot(product.getCategoryName(), product.getId());
//		if(count > 0) {
//			throw new RuntimeException("Category's name existed.");
//		}
//		
//		BeanUtils.copyProperties(product, loaded);		
//		return catRepo.save(loaded);
		return null;
	}

	@Override
	public Category findById(int id) {
		return catRepo.findById(id).orElseThrow(()->new RuntimeException("Category's ID not found."));
	}

	@Override
	public String deleteById(int id) {
		Category loaded = catRepo.findById(id).orElseThrow(()->new RuntimeException("Category's ID not found."));
		
		//products existed;
		if(loaded.getProducts().size() != 0) {
			throw new RuntimeException("Products existed.");
		}
		
		catRepo.delete(loaded);
		return "Successfully deleted.";
	}

	/*
	 * @Override public List<Category> findAll() { // TODO Auto-generated method
	 * stub return categoryRepository.findAll(); }
	 */
	/*
	 * @Override public int insert(Category product) { // TODO Auto-generated method
	 * stub return categoryRepository.insert(product); }
	 */

	@Override
	public Page<Category> findByNameContaining(String name, Pageable pageable) {
		System.err.println("search...");
		return catRepo.findByNameContaining(name, pageable);
	}

	/*
	 * @Override public int deleteAll() { // TODO Auto-generated method stub return
	 * categoryRepository.deleteAll(); }
	 */
	
	
	//@PostConstruct
	void test() {
		//database initiase
//		Category category = Category.builder().categoryName(new Date().toGMTString()).build();
//		save(category);
	}

}
