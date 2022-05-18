package com.ssafy.ownmate.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ownmate.model.dto.Video;
import com.ssafy.ownmate.model.service.VideoService;

@RestController
@RequestMapping("/api")
public class VideoController {

	private static String SUCCESS = "success";
	private static String FAIL = "fail";

	@Autowired
	private VideoService videoService;

	@GetMapping("/video")
	public ResponseEntity<List<Video>> list(@RequestParam(defaultValue = "") String keyword) {
		return new ResponseEntity<List<Video>>(videoService.getVideoList(keyword), HttpStatus.OK);
	}

	@GetMapping("/video/{videoId}")
	public ResponseEntity<Video> detail(@PathVariable String videoId) {
		return new ResponseEntity<Video>(videoService.getVideoById(videoId), HttpStatus.OK);
	}
	
	
	

}
