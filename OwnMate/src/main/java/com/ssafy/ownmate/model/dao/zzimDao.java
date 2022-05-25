package com.ssafy.ownmate.model.dao;

import java.util.List;

import com.ssafy.ownmate.model.dto.Zzim;

public interface zzimDao {
	//찜 목록
	public List<Zzim> selectZzimList();
	
	//유저가 찜한것들 조회
	public List<Zzim> selectZzimByUser(String userId);
	
	//찜 등록
	public void insertZzim(Zzim zzim);
	
	//찜 삭제
	public int deleteZzim(int zzimNo);
}
