package com.ssafy.ownmate.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.ownmate.model.dto.Review;
import com.ssafy.ownmate.model.dto.User;

public interface UserService {
	// C - 회원가입
	void join(User user) throws Exception;
	


	// R - 로그인
	User login(String userId, String userPw) throws Exception;

	// U - 회원정보 수정
	boolean modifyUser(User user);

	// D - 회원탈퇴
	boolean dropUser(String userId);

	// 회원 조회
	public List<User> getUserList(String keyword);
	
	public User getUserById(String userId);
	
	//회원 몇 명 있나?
	public int chekId(String userId);
	

}
