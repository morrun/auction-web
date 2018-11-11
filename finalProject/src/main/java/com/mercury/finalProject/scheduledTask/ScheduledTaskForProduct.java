package com.mercury.finalProject.scheduledTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.finalProject.bean.OperationView;
import com.mercury.finalProject.bean.Product;
import com.mercury.finalProject.bean.ShelvesProduct;
import com.mercury.finalProject.dao.ShelvesProductDao;
import com.mercury.finalProject.service.OperationViewService;
import com.mercury.finalProject.service.ProductService;
import com.mercury.finalProject.service.ShelvesProductService;

@Service
@Transactional
public class ScheduledTaskForProduct {
	
	@Autowired
	private ShelvesProductService sps;
	@Autowired
	private ProductService ps;
	@Autowired
	private ShelvesProductDao spd;
	@Autowired
	private OperationViewService ovs;
	@Scheduled(fixedRate = 3 * 60 * 60 * 1000)
	public void create() {
		List<ShelvesProduct> sp = sps.getAllShelvesProducts();
		List<Integer> idList = new ArrayList<Integer>();
		for (ShelvesProduct ts: sp) {
			idList.add(ts.getProductId());
		}
		List<Product> pList = ps.getProductsById(idList);
		for (Product tp: pList) {
			if (tp.getDeadline().compareTo(new Date()) < 0) {
				handlePassDeadlineProduct(tp);
			}
		}
	}
	
	private void handlePassDeadlineProduct(Product p) {

		OperationView op;
		List<OperationView> ovList = ovs.getByProductId(p.getId());
		if (!ovList.isEmpty()) {
			Collections.sort(ovList, (ov1, ov2) -> {
				return ov2.getNowPrice() - ov1.getNowPrice();
			});
			op = ovList.get(0);
			op.setViewStatus(1);
			ovs.updateOperationView(op);
		}
		spd.deleteByProductId(p.getId());
	}
}
