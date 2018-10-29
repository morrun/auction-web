package com.mercury.finalProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.finalProject.bean.ProductImage;

public interface ProductImageDao extends JpaRepository<ProductImage, Integer> {
	public List<ProductImage> findByProductId(Integer id);
}
