package com.mercury.finalProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mercury.finalProject.bean.VisitHistory;

public interface VisitHistoryDao extends JpaRepository<VisitHistory, Integer> {
//	@Query("select v.productId from (select vh.productId, count(*) as new_product_id from VisitHistory vh group by vh.productId order by new_product_id desc) v")
//	List<Integer> getProductIdListByVisitTimes();
	void deleteAllByProductId(int productId);
}
