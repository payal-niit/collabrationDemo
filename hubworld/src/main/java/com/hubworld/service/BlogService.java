package com.hubworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hubworld.dao.BlogDAOImpl;
import com.hubworld.model.Blog;

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

}
