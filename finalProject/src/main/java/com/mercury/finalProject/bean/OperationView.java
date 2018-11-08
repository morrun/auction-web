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
@Table(name = "ecb_operations_view")
public class OperationView {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ECB_OPERATIONS_VIEW_SEQ_GEN")
	@SequenceGenerator(name = "ECB_OPERATIONS_VIEW_SEQ_GEN", sequenceName = "ECB_OPERATIONS_VIEW_SEQ",allocationSize = 1)
	private int id;
	
	@Column
	private int sellerUserId;
	
	@Column
	private String sellerUserName;
	
	@Column
	private int buyerUserId;
	
	@Column
	private String buyerUserName;
	
	@Column
	private int originalPrice;
	
	@Column
	private int nowPrice;
	
	@Column
	private int viewStatus;
	
	@Column
	private int productId;
	
	@Column(name = "operation_date")
	@JsonFormat(pattern = "yyyy/mm/dd")
	private Date operationDate;

	public OperationView(int id, int sellerUserId, String sellerUserName, int buyerUserId, String buyerUserName,
			int originalPrice, int nowPrice, int viewStatus, int productId, Date operationDate) {
		super();
		this.id = id;
		this.sellerUserId = sellerUserId;
		this.sellerUserName = sellerUserName;
		this.buyerUserId = buyerUserId;
		this.buyerUserName = buyerUserName;
		this.originalPrice = originalPrice;
		this.nowPrice = nowPrice;
		this.viewStatus = viewStatus;
		this.productId = productId;
		this.operationDate = operationDate;
	}

	public OperationView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSellerUserId() {
		return sellerUserId;
	}

	public void setSellerUserId(int sellerUserId) {
		this.sellerUserId = sellerUserId;
	}

	public String getSellerUserName() {
		return sellerUserName;
	}

	public void setSellerUserName(String sellerUserName) {
		this.sellerUserName = sellerUserName;
	}

	public int getBuyerUserId() {
		return buyerUserId;
	}

	public void setBuyerUserId(int buyerUserId) {
		this.buyerUserId = buyerUserId;
	}

	public String getBuyerUserName() {
		return buyerUserName;
	}

	public void setBuyerUserName(String buyerUserName) {
		this.buyerUserName = buyerUserName;
	}

	public int getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(int originalPrice) {
		this.originalPrice = originalPrice;
	}

	public int getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(int nowPrice) {
		this.nowPrice = nowPrice;
	}

	public int getViewStatus() {
		return viewStatus;
	}

	public void setViewStatus(int viewStatus) {
		this.viewStatus = viewStatus;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	@Override
	public String toString() {
		return "OperationView [id=" + id + ", sellerUserId=" + sellerUserId + ", sellerUserName=" + sellerUserName
				+ ", buyerUserId=" + buyerUserId + ", buyerUserName=" + buyerUserName + ", originalPrice="
				+ originalPrice + ", nowPrice=" + nowPrice + ", viewStatus=" + viewStatus + ", productId=" + productId
				+ ", operationDate=" + operationDate + "]";
	}
	
	
}
