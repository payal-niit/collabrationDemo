package com.hubworld.dao;

import java.util.List;


import com.hubworld.model.Forum;

public interface ForumDAO {
	
	public List<Forum> list();
	
	public Forum get(int forumId);

	public void saveOrUpdate(Forum forum);
	
	public void deleteForum(int forumId);
	
	public Forum getForumById(int forumId);

}
