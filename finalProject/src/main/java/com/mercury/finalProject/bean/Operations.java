package com.mercury.finalProject.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ecb_operations")
public class Operations {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ECB_OPERATIONS_SEQ_GEN")
	@SequenceGenerator(name = "ECB_OPERATIONS_SEQ_GEN", sequenceName = "ECB_OPERATIONS_SEQ",allocationSize = 1)
	private int id;
	
	@Column
	private String type;
	
	@Column
	private int userId;

	public Operations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Operations(int id, String type, int userId) {
		super();
		this.id = id;
		this.type = type;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Operations [id=" + id + ", type=" + type + ", userId=" + userId + "]";
	}
	
	
}
