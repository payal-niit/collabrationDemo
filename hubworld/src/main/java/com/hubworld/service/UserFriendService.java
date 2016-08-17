package com.hubworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hubworld.dao.UserFriendDAOImpl;
import com.hubworld.model.UserFriend;
import com.hubworld.model.UserFriendTemp;

@Service
@Transactional
public class UserFriendService {
	@Autowired
	UserFriendDAOImpl userFriendDAO;

public void saveOrUpdateTemp(UserFriendTemp userFriendTemp) {
	userFriendDAO.saveOrUpdateTemp(userFriendTemp);
}

public void updateTemp(UserFriendTemp userFriendTemp) {
	userFriendDAO.updateTemp(userFriendTemp);
}



	public List<UserFriendTemp> getFriendById(int friendId) {
		return userFriendDAO.getFriendById(friendId);
	}
	
	public List<UserFriendTemp> getFriendByIdAccept(int userId) {
		return userFriendDAO.getFriendByIdAccept(userId);
	}
	
	public List<UserFriend> getFriendListById(int userId) {
		return userFriendDAO.getFriendListById(userId);
	}
	
	public void deleteFriend(int id) {
		userFriendDAO.deleteFriend(id);
	}
	
	public void saveOrUpdate(UserFriend userFriend) {
		userFriendDAO.saveOrUpdate(userFriend);
	}
	
	public void acceptfriend(int id) {
		userFriendDAO.acceptfriend(id);
	}

}
