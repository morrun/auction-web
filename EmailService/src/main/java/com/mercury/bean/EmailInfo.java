package com.mercury.bean;

import java.io.Serializable;

public class EmailInfo implements Serializable {
	private static final long serialVersionUID = 283408907869273L;
	
	private String to;
	private String subject;
	private String text;
	public EmailInfo(String to, String subject, String text) {
		super();
		this.to = to;
		this.subject = subject;
		this.text = text;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "EmailInfo [to=" + to + ", subject=" + subject + ", text=" + text + "]";
	}
	public EmailInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
