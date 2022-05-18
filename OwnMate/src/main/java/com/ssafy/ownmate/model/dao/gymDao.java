package com.ssafy.ownmate.model.dao;

import java.util.List;

import com.ssafy.ownmate.model.dto.Gym;

public interface gymDao {
	//gym 목록
	public List<Gym> selectGymList();
	
	//gym 하나 조회
	public Gym selectGymByNo(int gymNo);
}
