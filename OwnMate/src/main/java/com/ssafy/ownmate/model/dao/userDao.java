package com.ssafy.ownmate.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.ownmate.model.dto.User;

public interface userDao {
	//전체 user가져오기 - 팔로우할 유저 검색기능 추가를 위해 hashMap 사용
	public List<User> selectUserList(HashMap<String, String> params);
	
	//C - 유저 생성
	public void insertUser(User user);
	
	//R - id로 유저 불러오기
	public User selectUserById(int id);
	
	//U - 유저 정보 수정
	public int updateUser(User user);
	
	//D - 유저 삭제
	public int deleteUser(int id);
}
