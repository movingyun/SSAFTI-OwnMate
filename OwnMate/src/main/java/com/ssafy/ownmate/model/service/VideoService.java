package com.ssafy.ownmate.model.service;

import java.util.List;

import com.ssafy.ownmate.model.dto.Video;

public interface VideoService {
	//모든비디오 조회
	List<Video> getVideoList(String keyword); 
	
	//조회수로 정렬하기
	List<Video> getVideoByViewCnt(String keyword);
	
	//비디오 하나 조회
	Video getVideoById(String videoId);

	//부위로 찾기
	List<Video> getVideoByPart(String videoPart);
	
	//조회수 올리기
	void updateCnt(String videoId);
	

}
