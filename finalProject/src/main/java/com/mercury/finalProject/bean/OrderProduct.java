package com.mercury.finalProject.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ecb_order_product")
public class OrderProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ECB_ORDER_PRODUCT_SEQ_GEN")
	@SequenceGenerator(name = "ECB_ORDER_PRODUCT_SEQ_GEN", sequenceName = "ECB_ORDER_PRODUCT_SEQ",allocationSize = 1)
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "purchase_date")
	@JsonFormat(pattern = "yyyy/mm/dd")
	private Date purchaseDate;
	
	@Column
	private int price;
	public OrderProduct(int id, int userId, int productId, Date purchaseDate, int price) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.purchaseDate = purchaseDate;
		this.price = price;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public OrderProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", userId=" + userId + ", productId=" + productId + ", purchaseDate="
				+ purchaseDate + ", price=" + price + "]";
	}

	
	
	
}
