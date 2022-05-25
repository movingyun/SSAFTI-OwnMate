package com.ssafy.ownmate.model.service;

import java.util.List;

import com.ssafy.ownmate.model.dto.Follower;

public interface FollowerService {
	//전체 팔로우 목록
	public List<Follower> getFollowerList();
	
	//유저의 팔로우 목록
	public List<Follower> getFollowerByUser(String followerUserId);
	
	//팔로우 등록
	public void addFollower(Follower follower);
	
	//팔로우 삭제
	public boolean deleteFollower(int followerNo);
}
