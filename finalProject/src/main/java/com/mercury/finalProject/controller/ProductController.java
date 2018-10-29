package com.mercury.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.finalProject.bean.Product;
import com.mercury.finalProject.http.Response;
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
	
	@GetMapping("/products-list/{id}")
	public List<Product> getProductsByID(@PathVariable("id") List<Integer> ids){ 
		return productServiceImpl.getProductsById(ids);
	}
	@PostMapping("/products")
	public Response addProduct(@RequestBody Product p) {
		return productServiceImpl.addProduct(p);
	}
	@GetMapping("/products/type/{id}")
	public List<Product> getProductByTypeId(@PathVariable("id") int id) {
		return productServiceImpl.getProductsByTypeId(id);
	}
}
