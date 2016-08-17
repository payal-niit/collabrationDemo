package com.hubworld.dao;

import java.util.List;

import com.hubworld.model.Blog;
import com.hubworld.model.UserProfile;

public interface UserProfileDAO {
	
	public List<UserProfile> list();

	public UserProfile get(int userProfileId);

	public void saveOrUpdate(UserProfile userProfileId);
	
	public UserProfile getProfileById(int userId);
    

}
