package com.ssafy.ownmate.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.ownmate.model.dto.Follower;

public interface followerDao {
	//팔로워 목록
	public List<Follower> selectFollowerList();
	
	//팔로워 하나 조회
	public List<Follower> selectFollowerById(String userId);
	
	//팔로워 등록
	public void insertFollower(Follower follower);
	
	//팔로워 삭제
	public int deleteFollower(int followerNo);
}
