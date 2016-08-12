package com.hubworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hubworld.dao.UserDAOImpl;
import com.hubworld.model.User;

@Service
public class UserService {
	@Autowired(required=true)
	private UserDAOImpl userDAO;
	
	public UserService() {
		
	}
	
	public UserService(UserDAOImpl userDAO) {
		super();
		this.userDAO = userDAO;
	}

	@Transactional
	public List<User> list() {
		return userDAO.list();
	}
	
	@Transactional
	public User getUserById(int userId) {
		return userDAO.getUserById(userId);
	}
	
	@Transactional
	public User getByName(String userName) {
		return userDAO.getByName(userName);
	}
	
	@Transactional
	public void saveOrUpdate(User user) {
		userDAO.saveOrUpdate(user);
	}
	
	@Transactional
	public void delete(int userId) {
		userDAO.delete(userId);
	}
	

}
