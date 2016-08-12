package com.hubworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hubworld.dao.ForumDAOImpl;
import com.hubworld.model.Forum;

@Service
@Transactional
public class ForumService {
	@Autowired
	private ForumDAOImpl forumDAO;

	public List<Forum> list() {
		return forumDAO.list();
	}

	public Forum get(int forumId) {
		return forumDAO.get(forumId);
	}

	public void saveOrUpdate(Forum forum) {
		forumDAO.saveOrUpdate(forum);
	}

	public void deleteForum(int forumId) {
		forumDAO.deleteForum(forumId);
	}

	public Forum getForumById(int forumId) {
		return forumDAO.getForumById(forumId);
	}

}
