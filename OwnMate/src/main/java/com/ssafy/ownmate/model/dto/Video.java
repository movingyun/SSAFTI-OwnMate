package com.ssafy.ownmate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
	private String videoId;
	private String videoTitle;
	private String videoPart;
	private String videoChannel;
	private String videoUrl;
	private int videoViewCnt;
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getVideoPart() {
		return videoPart;
	}
	public void setVideoPart(String videoPart) {
		this.videoPart = videoPart;
	}
	public String getVideoChannel() {
		return videoChannel;
	}
	public void setVideoChannel(String videoChannel) {
		this.videoChannel = videoChannel;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public int getVideoViewCnt() {
		return videoViewCnt;
	}
	public void setVideoViewCnt(int videoViewCnt) {
		this.videoViewCnt = videoViewCnt;
	}
	
	
}
