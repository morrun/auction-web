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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ecb_visit_history")
public class VisitHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ECB_VISIT_HISTORY_SEQ_GEN")
	@SequenceGenerator(name = "ECB_VISIT_HISTORY_SEQ_GEN", sequenceName = "ECB_VISIT_HISTORY_SEQ",allocationSize = 1)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "VISITATION_ID")
	private Visitation visitation;
	
	@Column(name = "product_id")
	private int productId;

	public VisitHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VisitHistory(int id, Visitation visitation, int productId) {
		super();
		this.id = id;
		this.visitation = visitation;
		this.productId = productId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Visitation getVisitation() {
		return visitation;
	}

	public void setVisitation(Visitation visitation) {
		this.visitation = visitation;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "VisitHistory [id=" + id + ", visitation=" + visitation + ", productId=" + productId + "]";
	}
	
	
}
