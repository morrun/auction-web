package com.mercury.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.finalProject.bean.Product;
import com.mercury.finalProject.service.ProductService;
import com.mercury.finalProject.serviceImpl.ProductServiceImpl;

@RestController
public class ProductController {
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		
		return productServiceImpl.getProducts();
	}
}
