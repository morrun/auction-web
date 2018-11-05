package com.mercury.finalProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.finalProject.bean.ProductType;

public interface ProductTypeDao extends JpaRepository<ProductType, Integer> {
	ProductType findById(int id);
}
