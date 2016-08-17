package com.hubworld.dao;

import java.util.List;

import com.hubworld.model.Blog;
import com.hubworld.model.BlogApproved;

public interface BlogDAO {
	
	public List<Blog> list();

	public Blog get(int blogId);

	public void saveOrUpdate(Blog blog);
	
	public void deleteBlog(int blogId);
	
	public Blog getBlogById(int blogId);
	
	//---- BlogApproveDAO-----------
	
	public List<BlogApproved> approvedList();
	
	public void saveApprovedBlog(BlogApproved blogApproved);
	




}
