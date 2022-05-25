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
import com.ssafy.ownmate.model.dto.Zzim;
import com.ssafy.ownmate.model.service.ZzimService;

@RestController
@RequestMapping("/api")
public class ZzimController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private ZzimService zzimService;
	
	//전체 찜 불러오기
	@GetMapping("/zzim")
	public ResponseEntity<List<Zzim>> list() {
		return new ResponseEntity<List<Zzim>>(zzimService.getZzimList(), HttpStatus.OK);
	}
	
	//아이디 리뷰 가져오기
	@GetMapping("/zzim/{userId}")
	public ResponseEntity<List<Zzim>> userZzim(@PathVariable String userId) {
		return new ResponseEntity<List<Zzim>>(zzimService.getZzimByUser(userId), HttpStatus.OK);
	}
	
	//찜 삭제
	@DeleteMapping("/zzim/{zzimNo}")
	public ResponseEntity<String> delete(@PathVariable int zzimNo){
		if(zzimService.deleteZzim(zzimNo)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	//찜 등록
	@PostMapping("/zzim")
	public ResponseEntity<String> write(Zzim zzim) {
		zzimService.addZzim(zzim);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
	}
}
