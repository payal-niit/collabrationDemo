package com.hubworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hubworld.dao.BlogCommentDAOImpl;
import com.hubworld.model.BlogComment;
@Service
@Transactional
public class BlogCommentService {
	
	@Autowired
	private BlogCommentDAOImpl blogCommentDAO;
	
	public List<BlogComment> list() {
		return blogCommentDAO.list();
	}
	
	public void saveOrUpdate(BlogComment blogComment) {
		blogCommentDAO.saveOrUpdate(blogComment);
	}
	
	public List<BlogComment> getCommentById(int blogAppId) {
		return blogCommentDAO.getCommentById(blogAppId);
	}

}
