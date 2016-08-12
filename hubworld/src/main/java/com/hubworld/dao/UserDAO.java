package com.hubworld.dao;

import java.util.List;

import com.hubworld.model.User;

public interface UserDAO {
	
	public List<User> list();

	public User getUserById(int userId);
	
	public User getByName(String userName);

	public void saveOrUpdate(User user);

	public void delete(int userId);
 
	

}
