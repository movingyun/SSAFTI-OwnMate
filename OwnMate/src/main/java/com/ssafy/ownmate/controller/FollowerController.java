package com.ssafy.ownmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ownmate.model.dto.Follower;
import com.ssafy.ownmate.model.dto.Zzim;
import com.ssafy.ownmate.model.service.FollowerService;

@RestController
@RequestMapping("/api")
public class FollowerController {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private FollowerService followerService;
	
	//전체 팔로우 불러오기
	@GetMapping("/follower")
	public ResponseEntity<List<Follower>> list() {
		return new ResponseEntity<List<Follower>>(followerService.getFollowerList(), HttpStatus.OK);
	}
	
	//특정 유저의 팔로워
	@GetMapping("/follower/{followerUserId}")
	public ResponseEntity<List<Follower>> userFollower(@PathVariable String followerUserId) {
		return new ResponseEntity<List<Follower>>(followerService.getFollowerByUser(followerUserId), HttpStatus.OK);
	}
	
	//팔로워 삭제
	@DeleteMapping("/follower/{followerNo}")
	public ResponseEntity<String> delete(@PathVariable int followerNo){
		if(followerService.deleteFollower(followerNo)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	//팔로워 등록하기
	@PostMapping("/follower")
	public ResponseEntity<String> write(Follower follower) {
		List<Follower> followerList = followerService.getFollowerList();
		int flag = 0;
		for(Follower f : followerList) {
			if(f.getFollowerTargetId().equals(follower.getFollowerTargetId())&&f.getFollowerUserId().equals(follower.getFollowerUserId())) {
				flag = 1;
			}
		}
		if(flag == 1) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
		else {
			followerService.addFollower(follower);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
		}
	}
}
