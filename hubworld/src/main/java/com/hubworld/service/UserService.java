package com.hubworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hubworld.dao.UserDAOImpl;
import com.hubworld.model.User;

@Service
@Transactional
public class UserService {
	@Autowired(required=true)
	private UserDAOImpl userDAO;
	
	public UserService() {
		
	}
	
	public UserService(UserDAOImpl userDAO) {
		super();
		this.userDAO = userDAO;
	}

	
	public List<User> list() {
		return userDAO.list();
	}
	
	
	public User getUserById(int userId) {
		return userDAO.getUserById(userId);
	}
	
	
	public User getByName(String username) {
		return userDAO.getByName(username);
	}
	
	
	public void saveOrUpdate(User user) {
		userDAO.saveOrUpdate(user);
	}
	

	public void delete(int userId) {
		userDAO.delete(userId);
	}
	
	public int getById(String userName) {
		return userDAO.getByName(userName).getUserId();
	}
	
	public String getName(int userId) {
		return userDAO.getUserById(userId).getUsername();
	}
	

}
