package com.user.demo.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserModel {
	
	@Id
	private long id;
	private String name;
	private String email;
	private String password;
	private Timestamp created_at;
	private String login_token;
	private int type;
	private String address;
	private int is_email_verified;
	private String mobile;
	
	
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserModel(long id, String name, String email, String password, Timestamp created_at, String login_token,
			int type, String address, int is_email_verified, String mobile_number) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.created_at = created_at;
		this.login_token = login_token;
		this.type = type;
		this.address = address;
		this.is_email_verified = is_email_verified;
		this.mobile = mobile_number;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public String getLogin_token() {
		return login_token;
	}
	public void setLogin_token(String login_token) {
		this.login_token = login_token;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getIs_email_verified() {
		return is_email_verified;
	}
	public void setIs_email_verified(int is_email_verified) {
		this.is_email_verified = is_email_verified;
	}
	public String getMobile_number() {
		return mobile;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile = mobile_number;
	}
	
	
	

}
