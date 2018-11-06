package com.mercury.finalProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.finalProject.bean.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
	List<Product> findByIdIn(List<Integer> ids);
	List<Product> findByProductTypeId(Integer id);
	Product findById(int id);
	Product findByTitleAndDescription(String title, String description);
}
