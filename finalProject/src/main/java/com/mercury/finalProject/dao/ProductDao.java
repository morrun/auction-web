package com.mercury.finalProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.finalProject.bean.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
