package com.ssafy.ownmate.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.ownmate.model.dto.Review;

public interface reviewDao {
	//리뷰 목록
	public List<Review> selectReview(HashMap<String, String> params);
	
	//리뷰 하나 조회
	public Review selectReviewByNo(int no);
	
	//리뷰 등록
	public void insertReview(Review review);
	
	//리뷰 삭제
	public int deleteReview(int no);
	
	//리뷰 수정
	public int updateReview(Review review);
}
