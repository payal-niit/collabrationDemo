package com.hubworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hubworld.dao.CategoryDAOImpl;
import com.hubworld.model.Category;

@Service
@Transactional
public class CategoryService {
	@Autowired
	private CategoryDAOImpl categoryDAO;
	
public List<Category> listCategory(){
	return categoryDAO.listCategory();
}
	
	public void addCategory(Category category) {
		categoryDAO.addCategory(category);
	}

}
