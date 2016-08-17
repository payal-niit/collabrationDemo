package com.hubworld.dao;

import java.util.List;

import com.hubworld.model.UserFriend;
import com.hubworld.model.UserFriendTemp;
import com.hubworld.model.UserProfile;



public interface UserFriendDAO {
	
	public List<UserFriend> list();

	public UserFriend get(int userId);

	public void saveOrUpdate(UserFriend userFriend);
	
	public void deleteFriend(int id);
	
//	----------Temp-----------
	
	public void saveOrUpdateTemp(UserFriendTemp userFriendTemp);
	
	public List<UserFriendTemp> getFriendById(int friendId);

}
