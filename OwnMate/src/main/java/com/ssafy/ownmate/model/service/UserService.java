package com.ssafy.ownmate.model.service;

import com.ssafy.ownmate.model.dto.User;

public interface UserService {
	// C - 회원가입
	void join(User user) throws Exception;

	// R - 로그인
	User login(String id, String pw) throws Exception;

	// U - 회원정보 수정
	boolean modifyUser(User user);
	
	// D - 회원탈퇴
	boolean dropUser(int userId);
	


}
