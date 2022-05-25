package com.ssafy.ownmate.model.service;

import java.util.List;

import com.ssafy.ownmate.model.dto.Zzim;

public interface ZzimService {
	//찜 목록
	public List<Zzim> getZzimList();
	
	//유저가 찜한거 하나 조회
	public List<Zzim> getZzimByUser(String userId);
	
	//찜 등록
	public void addZzim(Zzim zzim);
	
	//찜 삭제
	public boolean deleteZzim(int zzimNo);
}
