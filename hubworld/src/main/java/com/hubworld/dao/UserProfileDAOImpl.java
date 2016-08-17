package com.hubworld.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.hubworld.model.Blog;
import com.hubworld.model.Forum;
import com.hubworld.model.UserProfile;

@Repository
public class UserProfileDAOImpl implements UserProfileDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<UserProfile> list() {
		@SuppressWarnings("unchecked")
		List<UserProfile> bloglist = (List<UserProfile>) sessionFactory.getCurrentSession()
				.createCriteria(UserProfile.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return bloglist;
	}

	public UserProfile get(int userProfileId) {
		String hql = "from Product where userProfileId='" + userProfileId+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<UserProfile> profilelist = (List<UserProfile>) query.list();
		
		if (profilelist != null && !profilelist.isEmpty()) {
			return profilelist.get(0);
		}
		
		return null;
	}

	public void saveOrUpdate(UserProfile userProfileId) {
		sessionFactory.getCurrentSession().saveOrUpdate(userProfileId);
		
	}
	
	public UserProfile getProfileById(int userId) {
		Session session=sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserProfile.class);
		criteria.add(Restrictions.eq("userId",userId));
		session.flush(); 
		
		return (UserProfile)(criteria.list().get(0));
		
	}	
}
