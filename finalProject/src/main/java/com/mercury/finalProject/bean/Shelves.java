package com.mercury.finalProject.bean;

import java.util.Date;

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
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ecb_shelves")
public class Shelves {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ECB_SHELVES_SEQ_GEN")
	@SequenceGenerator(name = "ECB_SHELVES_SEQ_GEN", sequenceName = "ECB_SHELVES_SEQ",allocationSize = 1)
	private int id;
	
	@Column(name = "on_shelves_date")
	@JsonFormat(pattern = "yyyy/mm/dd")
	private Date onShelvesDate;
	
	@Column
	private String type;
	
	@Column(name = "user_id")
	private int userId;
	
	

	public Shelves() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOnShelvesDate() {
		return onShelvesDate;
	}

	public void setOnShelvesDate(Date onShelvesDate) {
		this.onShelvesDate = onShelvesDate;
	}

	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public Shelves(int id, Date onShelvesDate, int userId, String type) {
		super();
		this.id = id;
		this.onShelvesDate = onShelvesDate;
		this.userId = userId;
		this.type = type;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Shelves [id=" + id + ", onShelvesDate=" + onShelvesDate + ", userId=" + userId + ", type=" + type + "]";
	}
	
	
}
