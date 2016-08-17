package com.hubworld.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class BlogComment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogCommentId;
	private int blogAppId;
	private String username;
	@NotEmpty(message="You have to write something")
	private String comment;
	
	/*@ElementCollection
	@ManyToOne
	@JoinColumn(name="blog_id",nullable = false, updatable = false, insertable = false)
	private BlogApproved blogApproved;*/
	
	private int rating;

	public int getBlogCommentId() {
		return blogCommentId;
	}

	public void setBlogCommentId(int blogCommentId) {
		this.blogCommentId = blogCommentId;
	}

	public int getBlogAppId() {
		return blogAppId;
	}

	public void setBlogAppId(int blogAppId) {
		this.blogAppId = blogAppId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	/*public BlogApproved getBlogApproved() {
		return blogApproved;
	}

	public void setBlogApproved(BlogApproved blogApproved) {
		this.blogApproved = blogApproved;
	}*/

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String toString()
	{
		
		return "{blogCommentId : '" + blogCommentId + "'," + "blogAppId : '" + blogAppId + "'," + "username :'" + username + "'," + "comment :'" + comment + "'}";
	}
	
		
}
