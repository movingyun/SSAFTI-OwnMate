package com.ssafy.ownmate.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ownmate.model.dto.Review;
import com.ssafy.ownmate.model.service.ReviewService;

@RestController
@RequestMapping("/api")
public class ReviewController {

	private static String SUCCESS = "success";
	private static String FAIL = "fail";

	@Autowired
	private ReviewService reviewService;
	
	//전체 리뷰 불러오기
	@GetMapping("/review")
	public ResponseEntity<List<Review>> list(@RequestParam(defaultValue = "") String mode,
			@RequestParam(defaultValue = "") String keyword) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("mode", mode);
		params.put("keyword", keyword);
		return new ResponseEntity<List<Review>>(reviewService.getReviewList(params), HttpStatus.OK);
	}

	//리뷰 등록
	@PostMapping("/review")
	public ResponseEntity<String> write(Review review) {
		reviewService.writeReview(review);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
	}

	//리뷰 상세보기
	@GetMapping("/review/{reviewNo}")
	public ResponseEntity<Review> detail(@PathVariable int reviewNo) {
		return new ResponseEntity<Review>(reviewService.getReviewByNo(reviewNo), HttpStatus.OK);
	}
	
	//리뷰 삭제
	@DeleteMapping("/review/{reviewNo}")
	public ResponseEntity<String> delete(@PathVariable int reviewNo){
		if(reviewService.removeReview(reviewNo)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	//리뷰 수정
	@PutMapping("/review")
	public ResponseEntity<String> update(Review review){
		reviewService.modifyReview(review);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
}
