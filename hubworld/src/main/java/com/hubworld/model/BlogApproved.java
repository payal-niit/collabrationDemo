package com.hubworld.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class BlogApproved {
	
	private int blogAppId;
	private String username;
	@NotEmpty(message="Blog Name is compulsory")
	private String blogName;
	
	@NotEmpty(message="Blog category needs to be selected")
	private String blogCategory;
	
	@NotEmpty(message="Description should be added")
	private String blogDescription;
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)		
	public int getBlogAppId() {
		return blogAppId;
	}
	public void setBlogAppId(int blogAppId) {
		this.blogAppId = blogAppId;
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
		
		return "{username : '" + username + "'," + "blogAppId : '" + blogAppId + "'," + "blogName :'" + blogName + "'," + "blogCategory :'" + blogCategory + "'," + "blogDescription :'" + blogDescription + "'}";
	}

}
