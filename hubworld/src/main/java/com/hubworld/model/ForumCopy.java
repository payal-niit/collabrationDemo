package com.hubworld.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class ForumCopy {
	
	private int forumId;
	private int userId;
	
	private User user;
	@NotEmpty(message="Forum name cannot be empty")
	private String forumName;
	@NotEmpty(message="Category needs to be selected")
	private String forumCategory;
	@NotEmpty(message="Description cannot be empty")
	private String forumDescription;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateOfCreation;
	
	private MultipartFile forumImage;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId", nullable=false, updatable=false,insertable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getForumName() {
		return forumName;
	}
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	public String getForumCategory() {
		return forumCategory;
	}
	public void setForumCategory(String forumCategory) {
		this.forumCategory = forumCategory;
	}
	public String getForumDescription() {
		return forumDescription;
	}
	public void setForumDescription(String forumDescription) {
		this.forumDescription = forumDescription;
	}
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	@Transient
	public MultipartFile getForumImage() {
		return forumImage;
	}
	public void setForumImage(MultipartFile forumImage) {
		this.forumImage = forumImage;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
