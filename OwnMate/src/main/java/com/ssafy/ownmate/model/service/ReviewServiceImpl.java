package com.ssafy.ownmate.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ownmate.model.dao.reviewDao;
import com.ssafy.ownmate.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private reviewDao reviewDao;

	@Override
	public List<Review> getReviewList(HashMap<String, String> params) {
		return reviewDao.selectReviewList(params);
	}

	@Override
	public Review getReviewByNo(int reviewNo) {
		this.updateCnt(reviewNo);
		return reviewDao.selectReviewByNo(reviewNo);
	}

	@Override
	public void writeReview(Review review) {
		reviewDao.insertReview(review);
	}

	@Override
	public boolean modifyReview(Review review) {
		Review originReview = reviewDao.selectReviewByNo(review.getReviewNo());
		originReview.setReviewTitle(review.getReviewTitle());
		originReview.setReviewContent(review.getReviewContent());
		// 이거의 결과는 true false
		return reviewDao.updateReview(originReview) == 1;
	}

	@Override
	public boolean removeReview(int reviewNo) {
		return reviewDao.deleteReview(reviewNo) == 1;
	}

	@Override
	public void updateCnt(int reviewNo) {
		Review review = reviewDao.selectReviewByNo(reviewNo);
		review.setReviewViewCnt(review.getReviewViewCnt() + 1);
		reviewDao.updateReview(review);
	}

//	이걸 어디서 사용할지 고민해보자!!!
	@Override
	public void updateLikeCnt(int reviewNo) {
		Review review = reviewDao.selectReviewByNo(reviewNo);
		review.setReviewLikeCnt(review.getReviewLikeCnt() + 1);
		reviewDao.updateReview(review);
	}

	@Override
	public void updateDislikeCnt(int reviewNo) {
		Review review = reviewDao.selectReviewByNo(reviewNo);
		review.setReviewDislikeCnt(review.getReviewDislikeCnt() + 1);
		reviewDao.updateReview(review);
	}
}
