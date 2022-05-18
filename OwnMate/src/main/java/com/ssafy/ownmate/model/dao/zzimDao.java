package com.ssafy.ownmate.model.dao;

import java.util.List;

import com.ssafy.ownmate.model.dto.Zzim;

public interface zzimDao {
	//찜 목록
	public List<Zzim> selectZzimList();
	
	//찜 하나 조회
	public Zzim selectZzimByNo(int zzimNo);
	
	//찜 등록
	public void insertZzim(Zzim zzim);
	
	//찜 삭제
	public int deleteZzim(int zzimNo);
}
