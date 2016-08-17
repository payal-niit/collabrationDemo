package com.hubworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hubworld.dao.UserProfileDAOImpl;
import com.hubworld.model.UserProfile;

@Service
@Transactional
public class UserProfileService {
	
	@Autowired
	private UserProfileDAOImpl userProfileDAO;
	
	public List<UserProfile> list() {
		return userProfileDAO.list();
	}

	public UserProfile get(int userProfileId) {
		return userProfileDAO.get(userProfileId);
	}

	public void saveOrUpdate(UserProfile userProfileId) {
		userProfileDAO.saveOrUpdate(userProfileId);
	}
	
	public UserProfile getProfileById(int userId) {
		return userProfileDAO.getProfileById(userId);
	}

}
