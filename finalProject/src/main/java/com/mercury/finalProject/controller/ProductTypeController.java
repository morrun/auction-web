package com.mercury.finalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.finalProject.bean.ProductType;
import com.mercury.finalProject.service.ProductTypeService;

@RestController
public class ProductTypeController {
	@Autowired
	private ProductTypeService productTypeService;
	@GetMapping("/productTypes")
	public List<ProductType> getAllProductTypes() {
		return productTypeService.getAllProductTypes();
	}
	@GetMapping("/productTypes/{id}")
	public ProductType getProductTypeById(@PathVariable int id) {
		return productTypeService.getProductTypeById(id);
	}
}
