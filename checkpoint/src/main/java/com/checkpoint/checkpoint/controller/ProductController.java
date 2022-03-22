package com.checkpoint.checkpoint.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkpoint.checkpoint.dto.CreateProductDto;
import com.checkpoint.checkpoint.entity.Product;
import com.checkpoint.checkpoint.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/create-product")
	public ResponseEntity<String> createProduct(@Valid @RequestBody CreateProductDto createProductDto)
			throws IllegalStateException, IOException {
		return productService.createProduct(createProductDto);
	}
	
	@GetMapping("/get-products")
	public List<Product> getProducts() {
		return productService.getProducts();
	}
}
