package com.mercury.finalProject.service;

import java.util.List;

import com.mercury.finalProject.bean.ShelvesProduct;
import com.mercury.finalProject.http.Response;

public interface ShelvesProductService {
	public List<ShelvesProduct> getAllShelvesProducts();
	public Response addShelvesProduct(ShelvesProduct p);
	public ShelvesProduct getShelvesProductById(int id);
	public List<ShelvesProduct> getShelvesProductByUserId(int userId);
	public Response deleteShelvesProduct(ShelvesProduct p);
	long getRemainTime(int productId);
}
