package com.hubworld.model;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Blog {
	
	private int blogId;
	private String username;
	@NotEmpty(message="Blog Name is compulsory")
	private String blogName;
	
	@NotEmpty(message="Blog category needs to be selected")
	private String blogCategory;
	
	@NotEmpty(message="Description should be added")
	private String blogDescription;
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getBlogCategory() {
		return blogCategory;
	}
	public void setBlogCategory(String blogCategory) {
		this.blogCategory = blogCategory;
	}
	public String getBlogDescription() {
		return blogDescription;
	}
	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString()
	{
		
		return "{username : '" + username + "'," + "blogId : '" + blogId + "'," + "blogName :'" + blogName + "'," + "blogCategory :'" + blogCategory + "'," + "blogDescription :'" + blogDescription + "'}";
	}
}
