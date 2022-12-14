package com.project.server.model;

import com.project.server.entity.User;

public class UserModel {
	public String id;
	public String name;
	public int balance;
	
	public UserModel(User entity) {
		this.id = entity.id;
		this.name= entity.name;
		this.balance = entity.balance;
	}
}
