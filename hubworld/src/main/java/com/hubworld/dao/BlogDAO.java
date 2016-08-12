package com.hubworld.dao;

import java.util.List;

import com.hubworld.model.Blog;

public interface BlogDAO {
	public List<Blog> list();

	public Blog get(int blogId);

	public void saveOrUpdate(Blog blog);
	
	public void deleteBlog(int blogId);
	
	public Blog getBlogById(int blogId);
	




}
