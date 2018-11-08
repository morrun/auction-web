package com.mercury.finalProject.service;

import java.util.List;

import com.mercury.finalProject.bean.OperationView;
import com.mercury.finalProject.http.Response;

public interface OperationViewService {
	List<OperationView> getBySellerUserId(int sellerUserId);
	List<OperationView> getByBuyerUserId(int buyerUserId);
	Response addOperationView(OperationView ov);
	Response updateOperationView(OperationView ov);
}
