package com.mercury.finalProject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mercury.finalProject.bean.Product;
import com.mercury.finalProject.http.Response;


public interface ProductService {
	public List<Product> getProducts();
	public List<Product> getProductsById(List<Integer> ids);
	public Response addProduct(Product p);
	public List<Product> getProductsByTypeId(int id);
}
