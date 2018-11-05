package com.mercury.finalProject.service;

import java.util.List;

import com.mercury.finalProject.bean.ProductType;

public interface ProductTypeService {
	public List<ProductType> getAllProductTypes();
	public ProductType getProductTypeById(int id);
}
