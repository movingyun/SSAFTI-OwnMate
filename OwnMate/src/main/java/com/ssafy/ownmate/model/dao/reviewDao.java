package com.ssafy.ownmate.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.ownmate.model.dto.Review;

public interface reviewDao {
	//리뷰 목록
	public List<Review> selectReviewList(HashMap<String, String> params);
	
	//리뷰 하나 조회
	public Review selectReviewByNo(int reviewNo);
	
	//리뷰 등록
	public void insertReview(Review review);
	
	//리뷰 삭제
	public int deleteReview(int reviewNo);
	
	//리뷰 수정
	public int updateReview(Review review);
}
