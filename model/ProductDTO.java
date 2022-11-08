package com.miniproject.model;

import com.miniproject.entity.Product;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.miniproject.entity.Category;
import com.miniproject.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

	public ProductDTO(Product payload) {
		super();
		BeanUtils.copyProperties(payload, this);
	}

	private int productId;

	@NotNull(message = "Name is required.")
	private String productName;
	
	private long barcode;
	
	private String description;
	
	@NotNull(message = "Price is required.")
	private float price;

	private String status;

}