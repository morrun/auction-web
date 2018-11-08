package com.mercury.finalProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mercury.finalProject.bean.ShelvesProduct;

public interface ShelvesProductDao extends JpaRepository<ShelvesProduct, Integer> {
	ShelvesProduct findByProductId(int id);
	@Query(value = "select * from (\r\n" + 
			"ecb_shelves_product esp inner join ecb_shelves es on esp.SHELVES_ID = es.ID\r\n" + 
			") where es.USER_ID = :userId",
			nativeQuery = true)
	List<ShelvesProduct> findByUserId(@Param("userId") int userId);
	
	void deleteByProductId(int productId);
}
