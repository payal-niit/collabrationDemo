package com.hubworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hubworld.dao.BlogDAOImpl;
import com.hubworld.model.Blog;
import com.hubworld.model.BlogApproved;

@Service
@Transactional
public class BlogService {
	@Autowired
	private BlogDAOImpl blogDAO;

	public List<Blog> list() {
		return blogDAO.list();
	}

	public Blog get(int blogId) {
		return blogDAO.get(blogId);
	}

	public void saveOrUpdate(Blog blog) {
		blogDAO.saveOrUpdate(blog);
	}

	public void deleteBlog(int blogId) {
		blogDAO.deleteBlog(blogId);
	}

	public Blog getBlogById(int blogId) {
		return blogDAO.getBlogById(blogId);
	}
	
	public String getBlogName(int blogId) {
		return blogDAO.getBlogById(blogId).getBlogName();
	}
	
	
	public String getCategory(int blogId) {
		return blogDAO.getBlogById(blogId).getBlogCategory();
	}
	
	public String getDescription(int blogId) {
		return blogDAO.getBlogById(blogId).getBlogDescription();
	}
	
	public String getUsername(int blogId) {
		return blogDAO.getBlogById(blogId).getUsername();
	}
	
	
	
	public List<BlogApproved> approvedList() {
		return blogDAO.approvedList();
	}
	
	public void saveApprovedBlog(BlogApproved blogApproved) {
		blogDAO.saveApprovedBlog(blogApproved);
	}
	
//	---------------for approved blogs----------------
	
	public BlogApproved getBlogAppById(int blogAppId) {
		return blogDAO.getBlogAppById(blogAppId);
	}
	
	public int getblogAppId(int blogAppId) {
		return blogDAO.getBlogAppById(blogAppId).getBlogAppId();
	}

	
	

}
