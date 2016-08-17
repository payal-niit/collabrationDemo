package com.hubworld.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hubworld.model.Blog;
import com.hubworld.model.BlogComment;

@Repository
public class BlogCommentDAOImpl implements BlogCommentDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public List<BlogComment> list() {
		@SuppressWarnings("unchecked")
		List<BlogComment> commentList = sessionFactory.getCurrentSession().createCriteria(BlogComment.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return commentList;
	}

	public void saveOrUpdate(BlogComment blogComment) {
		sessionFactory.getCurrentSession().saveOrUpdate(blogComment);
		
	}

	public List<BlogComment> getCommentById(int blogAppId) {
		Session session=sessionFactory.openSession();
		Criteria criteria = session.createCriteria(BlogComment.class);
		criteria.add(Restrictions.eq("blogAppId", blogAppId));
		@SuppressWarnings("unchecked")
		List<BlogComment> commentListbyId= (List<BlogComment>)(criteria.list());
		return commentListbyId;
	}

}
