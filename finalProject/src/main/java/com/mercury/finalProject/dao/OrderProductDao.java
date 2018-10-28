package com.mercury.finalProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.finalProject.bean.OrderProduct;

public interface OrderProductDao extends JpaRepository<OrderProduct, Integer> {

}
