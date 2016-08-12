package com.hubworld.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	@NotEmpty(message = "Username cannot be empty")
	private String username;
	@Size(min = 8, max = 15, message = "password should be minimum 8 characters")
	private String password;
	private String gender;

	private MultipartFile image;
	private String role;
	private boolean enabled;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Transient
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString()
	{
		
		return "{userId : '" + userId + "'," + "username : '" + username + "'," + "password :'" + password + "'," + "role :'" + role + "'," + "enabled :'" + enabled + "'," + "gender :'" + gender + "',"+"image :'resources/images/" +userId + ".jpg'}";
	}



}
