package com.ssafy.ownmate.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.ownmate.model.dto.Video;

public interface videoDao {
	//video전체 가져오기
	public List<Video> selectVideoList(HashMap<String, String> params);
	
	//R - id로 찾기
	public Video selectVideoById(String videoId);
	
	//R - part로 찾기
	public List<Video> selectPart(String videoPart);
}
