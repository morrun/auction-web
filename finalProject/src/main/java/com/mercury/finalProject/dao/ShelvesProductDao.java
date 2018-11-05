package com.mercury.finalProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.finalProject.bean.ShelvesProduct;

public interface ShelvesProductDao extends JpaRepository<ShelvesProduct, Integer> {
	ShelvesProduct findByProductId(int id);
}
