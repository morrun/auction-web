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
@Table(name = "ecb_visitation")
public class Visitation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "ECB_VISITATION_SEQ_GEN")
	@SequenceGenerator(name = "ECB_VISITATION_SEQ_GEN", sequenceName = "ECB_VISITATION_SEQ",allocationSize = 1)
	private int id;
	
	@Column(name = "VISITATION_DATE")
	@JsonFormat(pattern = "yyyy/mm/dd")
	private Date visitationDate;
	
	@Column(name = "user_id")
	private int userId;

	public Visitation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Visitation(int id, Date visitationDate, int userId) {
		super();
		this.id = id;
		this.visitationDate = visitationDate;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getVisitationDate() {
		return visitationDate;
	}

	public void setVisitationDate(Date visitationDate) {
		this.visitationDate = visitationDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Visitation [id=" + id + ", visitationDate=" + visitationDate + ", userId=" + userId + "]";
	}
	
	
}
