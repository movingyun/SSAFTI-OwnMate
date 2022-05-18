package com.ssafy.ownmate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//User 들어갔니?
//유경 수정될까?
//마지막 확인
//다시 되나
//최종확인
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
