package com.ssafy.ownmate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	private String reviewVideoId;
	private int reviewNo;
	private String reviewTitle;
	private String reviewWriter;
	private String reviewContent;
	private int reviewViewCnt;
	private int reviewLikeCnt;
	private int reviewDislikeCnt;
	private int reviewPw;
	public String getReviewVideoId() {
		return reviewVideoId;
	}
	public void setReviewVideoId(String reviewVideoId) {
		this.reviewVideoId = reviewVideoId;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public int getReviewViewCnt() {
		return reviewViewCnt;
	}
	public void setReviewViewCnt(int reviewViewCnt) {
		this.reviewViewCnt = reviewViewCnt;
	}
	public int getReviewLikeCnt() {
		return reviewLikeCnt;
	}
	public void setReviewLikeCnt(int reviewLikeCnt) {
		this.reviewLikeCnt = reviewLikeCnt;
	}
	public int getReviewDislikeCnt() {
		return reviewDislikeCnt;
	}
	public void setReviewDislikeCnt(int reviewDislikeCnt) {
		this.reviewDislikeCnt = reviewDislikeCnt;
	}
	public int getReviewPw() {
		return reviewPw;
	}
	public void setReviewPw(int reviewPw) {
		this.reviewPw = reviewPw;
	}
	
}
