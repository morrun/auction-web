package com.mercury.finalProject.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ECB_OPERATIONS_HISTORY")
public class OperationsHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ECB_OPERATIONS_HISTORY_SEQ_GEN")
	@SequenceGenerator(name = "ECB_OPERATIONS_HISTORY_SEQ_GEN", sequenceName = "ECB_OPERATIONS_HISTORY_SEQ",allocationSize = 1)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "operations_id")
	//@JsonIgnore
	private Operations operations;
	
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "operation_date")
	@JsonFormat(pattern = "yyyy/mm/dd")
	private Date operationDate;
	
	@Column(name = "price")
	private int price;

	public OperationsHistory(int id, Operations operations, int productId, Date operationDate, int price) {
		super();
		this.id = id;
		this.operations = operations;
		this.productId = productId;
		this.operationDate = operationDate;
		this.price = price;
	}

	public OperationsHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OperationsHistory [id=" + id + ", operations=" + operations + ", productId=" + productId
				+ ", operationDate=" + operationDate + ", price=" + price + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Operations getOperations() {
		return operations;
	}

	public void setOperations(Operations operations) {
		this.operations = operations;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
