package com.ssafy.ownmate.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ownmate.model.dto.Review;
import com.ssafy.ownmate.model.dto.User;
import com.ssafy.ownmate.model.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private static String SUCCESS = "success";
	private static String FAIL = "fail";
	private ServletContext servletContext;

	@Autowired
	private UserService userService;
	
	//로그인
//	@PostMapping("/login")
	
	//회원가입
	@PostMapping("/join")
	public ResponseEntity<String> join(User user, MultipartFile upload_file) throws Exception {
//		if( upload_file.getSize() != 0 ) {
//			String uploadPath = servletContext.getRealPath("/file");
//			String fileName = upload_file.getOriginalFilename();
//			String saveName = UUID.randomUUID()+"";
//			File target = new File(uploadPath, saveName);
//			if( !new File(uploadPath).exists() )
//				new File(uploadPath).mkdirs();
//			try {
//				FileCopyUtils.copy(upload_file.getBytes(), target);
//				user.setUserFileName(fileName);
//				user.setUserFileUri(target.getCanonicalPath());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		userService.join(user);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.CREATED);
	}
	
	//회원정보 수정
	
	
	//회원 탈퇴
	
	
	//회원조회
	@GetMapping("/user")
	public ResponseEntity<List<User>> searchUser(@RequestParam(defaultValue = "") String keyword) {
		return new ResponseEntity<List<User>>(userService.getUserList(keyword), HttpStatus.OK);
	}
}
