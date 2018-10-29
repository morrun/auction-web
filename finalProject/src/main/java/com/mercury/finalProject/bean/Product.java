package com.mercury.finalProject.bean;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ecb_product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ECB_PRODUCT_SEQ_GEN")
	@SequenceGenerator(name = "ECB_PRODUCT_SEQ_GEN", sequenceName = "ECB_PRODUCT_SEQ",allocationSize = 1)
	private int id;
	
	@Column
	private String title;
	
	@Column
	private String description;
	

//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "type_id")
//	@JsonIgnoreProperties("goods")
//	private ProductType productType;
	@Column(name = "type_id")
	private int productTypeId;
	
	@Column
	private int price;
	
	@Column
	@JsonFormat(pattern = "yyyy/mm/dd")
	private Date deadline;
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}



	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", productTypeId="
				+ productTypeId + ", price=" + price + ", deadline=" + deadline + "]";
	}

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public Product(int id, String title, String description, int productTypeId, int price, Date deadline) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.productTypeId = productTypeId;
		this.price = price;
		this.deadline = deadline;
	}

	

	
	


}
