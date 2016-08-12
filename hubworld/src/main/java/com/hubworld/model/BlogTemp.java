package com.hubworld.model;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class BlogTemp {
	
	private int blogId;
	private int userId;
	@NotEmpty(message="Blog Name is compulsory")
	private String blogName;
	
	@NotEmpty(message="Blog category needs to be selected")
	private String blogCategory;
	
	@NotEmpty(message="Description should be added")
	private String blogDescription;
	
	private User user;
	
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
	
	@ElementCollection
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId", nullable=false, updatable=false,insertable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	

}
