package com.mahesh.entity;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class User {
	@Id
	private long id;
	private String name;
	private String email;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameString() {
		return name;
	}
	public void setNameString(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
