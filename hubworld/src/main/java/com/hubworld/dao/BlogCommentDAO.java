package com.hubworld.dao;


import java.util.List;


import com.hubworld.model.BlogComment;
import com.hubworld.model.User;

public interface BlogCommentDAO {
	
	public List<BlogComment> list();
	public void saveOrUpdate(BlogComment blogComment);
	
	public List<BlogComment> getCommentById(int blogAppId); 

}
