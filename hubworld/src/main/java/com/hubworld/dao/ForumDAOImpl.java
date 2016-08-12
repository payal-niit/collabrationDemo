package com.hubworld.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hubworld.model.Forum;

@Repository
public class ForumDAOImpl implements ForumDAO{
	@Autowired
	private SessionFactory sessionFactory;

	public Forum get(int forumId) {
		String hql = "from Forum where forumId = + forumId+";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Forum> listForum = (List<Forum>) query.list();
		
		if (listForum != null && !listForum.isEmpty()) {
			return listForum.get(0);
		}
		
		return null;

	}

	public void saveOrUpdate(Forum forum) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum);

		
	}

	public void deleteForum(int forumId) {
		Forum ForumToDelete = new Forum();
		ForumToDelete.setForumId(forumId);
		sessionFactory.getCurrentSession().delete(ForumToDelete);
		
	}

	public Forum getForumById(int forumId) {
		Session session=sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Forum.class);
		criteria.add(Restrictions.eq("forumId",forumId));
		 
		
		return (Forum)(criteria.list().get(0));

	}

	public List<Forum> list() {
		@SuppressWarnings("unchecked")
		List<Forum> listProduct = (List<Forum>) sessionFactory.getCurrentSession()
				.createCriteria(Forum.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listProduct;
	}

		

}
