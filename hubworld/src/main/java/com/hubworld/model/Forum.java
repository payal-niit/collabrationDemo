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
public class Forum {
	
	private int forumId;
	private String username;
	
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString()
	{
		
		return "{forumId : '" + forumId + "'," + "username : '" + username + "'," + "forumName :'" + forumName + "'," + "forumCategory :'" + forumCategory + "'," + "forumDescription :'" + forumDescription + "'," + "dateOfCreation :'" + dateOfCreation + "'," + "forumImage :'resources/images/" +forumId + ".jpg'}";
	}
	

}
