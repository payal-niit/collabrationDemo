package com.hubworld.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hubworld.model.Blog;
@Repository
public class BlogDAOImpl implements BlogDAO{
	
	@Autowired
	private SessionFactory sessionFactory;


	public List<Blog> list() {
		@SuppressWarnings("unchecked")
		List<Blog> bloglist = (List<Blog>) sessionFactory.getCurrentSession()
				.createCriteria(Blog.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return bloglist;

	}

	public Blog get(int blogId) {
		String hql = "from Product where blogId='" + blogId+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Blog> bloglist = (List<Blog>) query.list();
		
		if (bloglist != null && !bloglist.isEmpty()) {
			return bloglist.get(0);
		}
		
		return null;
	
	}

	public void saveOrUpdate(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		
	}

	public void deleteBlog(int blogId) {
		Blog blogToDelete = new Blog();
		blogToDelete.setBlogId(blogId);
		sessionFactory.getCurrentSession().delete(blogToDelete);
	}

	public Blog getBlogById(int blogId) {
		Session session=sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Blog.class);
		criteria.add(Restrictions.eq("blogId", blogId));
		
		return (Blog)(criteria.list().get(0));

	}

}
