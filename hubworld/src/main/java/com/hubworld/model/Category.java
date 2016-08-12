package com.hubworld.model;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class Category {
	
	int categoryId;
	@NotEmpty(message="Name cannot be empty")
	String categoryName;
	@NotEmpty(message="Description cannot be empty")
	String description;
	
	@Id
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
