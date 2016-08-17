package com.hubworld.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hubworld.model.BlogComment;
import com.hubworld.model.UserFriend;
import com.hubworld.model.UserFriendTemp;

@Repository
public class UserFriendDAOImpl implements UserFriendDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<UserFriend> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserFriend get(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveOrUpdate(UserFriend userFriend) {
		sessionFactory.getCurrentSession().saveOrUpdate(userFriend);		
	}
	
	

	public void deleteFriend(int id) {
		UserFriendTemp userToDelete = new UserFriendTemp();
		userToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(userToDelete);
		
	}
	
	public void acceptfriend(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			 UserFriendTemp userFriendTemp = 
	                    (UserFriendTemp)session.get(UserFriendTemp.class, id);
			 userFriendTemp.setFlag("N");
			 session.update(userFriendTemp);
			 tx.commit();			 
		}
		catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
			
		}
		
		
		
	public List<UserFriend> getFriendListById(int userId) {
		Session session=sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserFriendTemp.class);
		criteria.add(Restrictions.eq("userId", userId));
		@SuppressWarnings("unchecked")
		List<UserFriend> friendAppListbyId= (List<UserFriend>)(criteria.list());
		return friendAppListbyId;
		}
	
//	---------------temp---------------------------

	public void saveOrUpdateTemp(UserFriendTemp userFriendTemp) {
		sessionFactory.getCurrentSession().saveOrUpdate(userFriendTemp);
		
	}
	
	public void updateTemp(UserFriendTemp userFriendTemp) {
		sessionFactory.getCurrentSession().update(userFriendTemp);
		
	}

	public List<UserFriendTemp> getFriendById(int friendId) {
		Session session=sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserFriendTemp.class);
		criteria.add(Restrictions.eq("friendId", friendId));
		criteria.add(Restrictions.eq("flag", "Y"));
		@SuppressWarnings("unchecked")
		List<UserFriendTemp> friendListbyId= (List<UserFriendTemp>)(criteria.list());
		session.flush();
		session.close();
		return friendListbyId;
		}
	
	public List<UserFriendTemp> getFriendByIdAccept(int friendId) {
		Session session=sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserFriendTemp.class);
		criteria.add(Restrictions.eq("friendId", friendId));
		criteria.add(Restrictions.eq("flag", "N"));
		@SuppressWarnings("unchecked")
		List<UserFriendTemp> friendListbyIdAccept= (List<UserFriendTemp>)(criteria.list());
		session.flush();
		session.close();
		return friendListbyIdAccept;
		}

}
