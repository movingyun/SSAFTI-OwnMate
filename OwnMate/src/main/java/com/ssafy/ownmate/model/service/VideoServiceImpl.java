package com.ssafy.ownmate.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ownmate.model.dao.videoDao;
import com.ssafy.ownmate.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private videoDao videoDao;

	@Override
	public List<Video> getVideoList(String keyword) {
		return videoDao.selectVideoList(keyword);
	}

	@Override
	public Video getVideoById(String videoId) {
		this.updateCnt(videoId);
		return videoDao.selectVideoById(videoId);
	}

	@Override
	public List<Video> getVideoByPart(String videoPart) {
		return videoDao.selectPart(videoPart);
	}

	@Override
	public void updateCnt(String videoId) {
		Video video = videoDao.selectVideoById(videoId);
		video.setVideoViewCnt(video.getVideoViewCnt() + 1);
		videoDao.updateVideo(video);
	}

	@Override
	public List<Video> getVideoListTop3() {
		return videoDao.selectVideoListTop3();
	}

}
