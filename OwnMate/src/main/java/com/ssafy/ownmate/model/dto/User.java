package com.ssafy.ownmate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String userId;
	private String userPw;
	private String userName;
	private int userGym;
	private int userAge;
	private int userExerciseCareer;
	private String userGender;
	private String userFileName;
	private String userFileUri;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserGym() {
		return userGym;
	}
	public void setUserGym(int userGym) {
		this.userGym = userGym;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public int getUserExerciseCareer() {
		return userExerciseCareer;
	}
	public void setUserExerciseCareer(int userExerciseCareer) {
		this.userExerciseCareer = userExerciseCareer;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserFileName() {
		return userFileName;
	}
	public void setUserFileName(String userFileName) {
		this.userFileName = userFileName;
	}
	public String getUserFileUri() {
		return userFileUri;
	}
	public void setUserFileUri(String userFileUri) {
		this.userFileUri = userFileUri;
	}
	
	
}
