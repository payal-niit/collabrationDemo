package com.hubworld.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hubworld.model.Category;
@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Category> listCategory() {
		List<Category> listCategory = sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCategory;
	}

	public void addCategory(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);

	}

}
