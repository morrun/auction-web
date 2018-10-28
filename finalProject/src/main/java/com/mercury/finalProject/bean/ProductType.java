package com.mercury.finalProject.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ecb_product_type")
public class ProductType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ECB_PRODUCT_TYPE_SEQ_GEN")
	@SequenceGenerator(name = "ECB_PRODUCT_TYPE_SEQ_GEN", sequenceName = "ECB_PRODUCT_TYPE_SEQ", allocationSize = 1)
	private int ID;
	
	@Column
	private String type;
	
	@OneToMany(mappedBy = "productType", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Product> goods;
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ProductType() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public List<Product> getGoods() {
		return goods;
	}

	public void setGoods(List<Product> goods) {
		this.goods = goods;
	}

	public ProductType(int iD, String type, List<Product> goods) {
		super();
		ID = iD;
		this.type = type;
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "ProductType [ID=" + ID + ", type=" + type + ", goods=" + goods + "]";
	}


	
	
}
