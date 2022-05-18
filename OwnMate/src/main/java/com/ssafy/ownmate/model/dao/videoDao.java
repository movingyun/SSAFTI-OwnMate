package com.ssafy.ownmate.model.dao;

import java.util.List;

import com.ssafy.ownmate.model.dto.Video;

public interface videoDao {
	//video전체 가져오기
	public List<Video> selectVideoList(String keyword);
	
	//video 조회순으로 가져오기
	public List<Video> selectVideoByViewCnt();
	
	//R - id로 찾기
	public Video selectVideoById(String videoId);
	
	//R - part로 찾기
	public List<Video> selectPart(String videoPart);
	
	//U -video수정(조회수 증가)
	public int updateVideo(Video video);
}
