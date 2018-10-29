package com.mercury.finalProject.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ecb_shelves_product")
public class ShelvesProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ECB_SHELVES_PRODUCT_SEQ_GEN")
	@SequenceGenerator(name = "ECB_SHELVES_PRODUCT_SEQ_GEN", sequenceName = "ECB_SHELVES_PRODUCT_SEQ",allocationSize = 1)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "shelves_id")
	private Shelves shelves;
	
	@Column(name = "product_id")
	private int productId;

	public ShelvesProduct(int id, Shelves shelves, int productId) {
		super();
		this.id = id;
		this.shelves = shelves;
		this.productId = productId;
	}

	public ShelvesProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Shelves getShelves() {
		return shelves;
	}

	public void setShelves(Shelves shelves) {
		this.shelves = shelves;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "ShelvesProduct [id=" + id + ", shelves=" + shelves + ", productId=" + productId + "]";
	}
	
	
}
