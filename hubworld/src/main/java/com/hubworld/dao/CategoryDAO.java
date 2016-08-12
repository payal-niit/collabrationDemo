package com.hubworld.dao;

import java.util.List;

import com.hubworld.model.Category;

public interface CategoryDAO {
	
	public List<Category> listCategory();
	
	public void addCategory(Category category);

}
