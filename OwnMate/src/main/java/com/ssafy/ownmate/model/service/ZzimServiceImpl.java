package com.ssafy.ownmate.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ownmate.model.dao.zzimDao;
import com.ssafy.ownmate.model.dto.Zzim;

@Service
public class ZzimServiceImpl implements ZzimService {
	
	@Autowired
	private zzimDao zzimDao;
	
	@Override
	public List<Zzim> getZzimList() {
		return zzimDao.selectZzimList();
	}

	@Override
	public List<Zzim> getZzimByUser(String userId) {
		return zzimDao.selectZzimByUser(userId);
	}

	@Override
	public void addZzim(Zzim zzim) {
		zzimDao.insertZzim(zzim);
	}

	@Override
	public boolean deleteZzim(int zzimNo) {
		return zzimDao.deleteZzim(zzimNo) == 1;
	}
}
