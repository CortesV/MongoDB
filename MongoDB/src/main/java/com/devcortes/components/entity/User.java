package com.devcortes.components.entity;

public class User {
	
	public static String TABLE_NAME = "persons";
	
	private Integer id;
	private String login;
	private String password;

	public User(String login) {
		this.login = login;
	}

	public User() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + "]";
	}

}
