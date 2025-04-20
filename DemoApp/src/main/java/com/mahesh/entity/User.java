package com.mahesh.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document(collection="user_entries")
@Getter
@Setter
// @Data  --> combination of @Getter and @Setter
public class User {
	@Id
	private ObjectId id;
	private String name;
	private String email;
	
//	public ObjectId getId() {
//		return id;
//	}
//	public void setId(ObjectId id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
	
	
}
