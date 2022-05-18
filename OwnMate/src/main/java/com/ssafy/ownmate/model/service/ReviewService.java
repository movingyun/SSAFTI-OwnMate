package com.ssafy.ownmate.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.ownmate.model.dto.Review;

public interface ReviewService {
	//모든리뷰 조회
	public List<Review> getReviewList(HashMap<String, String> params); 
	
	//리뷰 하나 조회
	Review getReviewByNo(int reviewNo);
	
	//리뷰 등록
	void writeReview(Review review);
	
	//리뷰 수정
	boolean modifyReview(Review review);
	
	//리뷰 삭제
	boolean removeReview(int reviewNo);
	
	//뷰카운트 증가
	void updateCnt(int reviewNo);
	
	//좋아요!! 증가
	void updateLikeCnt(int reviewNo);
	
	//싫어요!! 증가
	void updateDislikeCnt(int reviewNo);
}
