package com.hubworld.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userProfileId;
	private int userId;
	private String username;

	private String aboutUrself;
	@NotEmpty
	private String relationsipStatus;
	@NotEmpty(message = "Share, whats in your mind")
	private String wallMessage;
	@NotNull(message = "Age Compulsory")
	private int age;

	private String interests;
	private String info;
	private String qualification;
	private String reasonOfJoining;
	private Date dob;

	@OneToOne
	@JoinColumn(name = "userId", nullable = false, updatable = false, insertable = false)
	private User user;

	public int getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRelationsipStatus() {
		return relationsipStatus;
	}

	public void setRelationsipStatus(String relationsipStatus) {
		this.relationsipStatus = relationsipStatus;
	}

	public String getWallMessage() {
		return wallMessage;
	}

	public void setWallMessage(String wallMessage) {
		this.wallMessage = wallMessage;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getReasonOfJoining() {
		return reasonOfJoining;
	}

	public void setReasonOfJoining(String reasonOfJoining) {
		this.reasonOfJoining = reasonOfJoining;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}	

	public String getAboutUrself() {
		return aboutUrself;
	}

	public void setAboutUrself(String aboutUrself) {
		this.aboutUrself = aboutUrself;
	}

	public String toString() {

		return "{userProfileId : '" + userProfileId + "'," + "userId : '" + userId + "'," + "username : '" + username
				+ "'," + "relationsipStatus :'" + relationsipStatus + "'," + "wallMessage :'" + wallMessage + "',"
				+ "age :'" + age + "'," + "interests :'" + interests + "'," + "info :'" + info + "'," + "age :'" + age
				+ "'," + "qualification :'" + qualification + "'," + "reasonOfJoining :'" + reasonOfJoining + "'," + ""
				+ "dob :'" + dob + "'," + "aboutUrself :'" + aboutUrself + "'}";
	}

}
