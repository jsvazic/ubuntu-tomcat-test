package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {

	private int id;
	private String msg;
	
	public Message() {
	}
	
	@Id
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "msg")
	public String getMessage() {
		return msg;
	}
	
	public void setMessage(String msg) {
		this.msg = msg;
	}
}
