package com.devcortes.components.interfaces;

import java.util.List;

import com.devcortes.components.entity.User;

public interface IUserDao {

	public void add(User user);
	public void addMany(List<User> users);
	public void readAll();
	public void deleteByLogin(String login);
	public void clearCollection();
}

