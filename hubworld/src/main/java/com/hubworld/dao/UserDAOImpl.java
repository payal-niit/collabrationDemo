package com.hubworld.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hubworld.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class UserDAOImpl implements UserDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	public UserDAOImpl() {

	}

	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<User> list() {
		List<User> listuser = sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listuser;
	}

	public User getUserById(int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = session.load(User.class, new Integer(userId));
		logger.info("User loaded successfully" + user);
		session.flush();
		return user;
	}

	public User getByName(String username) {
		Session session=sessionFactory.openSession();
		Criteria c = session.createCriteria(User.class);
		c.add(Restrictions.eq("username", username));
		@SuppressWarnings("unchecked")
		List<User> user = c.list();
		
		return user.get(0);

	}

	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}

	public void delete(int userId) {
		Session session = sessionFactory.getCurrentSession();
		User userToDelete = new User();
		userToDelete.setUserId(userId);
		session.delete(userToDelete);

	}

}
