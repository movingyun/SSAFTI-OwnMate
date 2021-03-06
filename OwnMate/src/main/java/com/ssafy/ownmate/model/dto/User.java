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
}
