package com.checkpoint.checkpoint.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.checkpoint.checkpoint.dto.CreateProductDto;
import com.checkpoint.checkpoint.dto.ProductDto;
import com.checkpoint.checkpoint.entity.Category;
import com.checkpoint.checkpoint.entity.Product;
import com.checkpoint.checkpoint.repository.CategoryRepository;

import com.checkpoint.checkpoint.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	

	
	public List<Product> getProducts() {
		 return productRepository.findAll();
	}
	
	public ResponseEntity<String> createProduct(CreateProductDto createProductDto)
			throws IllegalStateException, IOException {
		Product product = new Product();
		
		Category category = categoryRepository.findById(createProductDto.getCategoryId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		product.setCategory(category);
		
		product.setTitle(createProductDto.getTitle());
		product.setDescription(createProductDto.getDescription());
		
		product = productRepository.save(product);
		
		return new ResponseEntity<>("Product created successfully", HttpStatus.OK);
	}
}
