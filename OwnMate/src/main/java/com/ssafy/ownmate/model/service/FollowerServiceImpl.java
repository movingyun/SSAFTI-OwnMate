package com.ssafy.ownmate.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ownmate.model.dao.followerDao;
import com.ssafy.ownmate.model.dto.Follower;

@Service
public class FollowerServiceImpl implements FollowerService {
	
	@Autowired
	private followerDao followerDao;
	
	@Override
	public List<Follower> getFollowerList() {
		return followerDao.selectFollowerList();
	}

	@Override
	public List<Follower> getFollowerByUser(String followerUserId) {
		return followerDao.selectFollowerById(followerUserId);
	}

	@Override
	public void addFollower(Follower follower) {
		followerDao.insertFollower(follower);
	}

	@Override
	public boolean deleteFollower(int followerNo) {
		return followerDao.deleteFollower(followerNo) == 1;
	}
}
