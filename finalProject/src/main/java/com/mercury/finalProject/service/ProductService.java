package com.mercury.finalProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.Product;


public interface ProductService {
	public List<Product> getProducts();
}
