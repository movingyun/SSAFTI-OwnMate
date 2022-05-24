package com.ssafy.ownmate.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ownmate.model.dto.User;
import com.ssafy.ownmate.model.service.UserService;
import com.ssafy.ownmate.util.JWTUtil;
import com.ssafy.ownmate.util.SHA256;

@RestController
@RequestMapping("/api")
public class UserController {

	private static String SUCCESS = "success";
	private static String FAIL = "fail";
	private ServletContext servletContext;

	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private UserService userService;

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(String userId, String userPw) {
		HttpStatus status = null;
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			if (userService.chekId(userId) == 1) {
				User originUser = userService.getUserById(userId);
				if (originUser.getUserPw().equals(new SHA256().getHash(userPw))) {
					// id정보가있는 토큰 생성
					result.put("access-token", jwtUtil.createToken("id", userId));
					result.put("message", SUCCESS);
					status = HttpStatus.ACCEPTED;
				} else {
					// 비밀번호가 틀리면 fail전송
					result.put("message", FAIL);
					status = HttpStatus.BAD_REQUEST;
				}
			} else {
				result.put("message", FAIL);
				status = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			result.put("message", FAIL);
			status = HttpStatus.NO_CONTENT;
		}
		return new ResponseEntity<Map<String, Object>>(result, status);
	}

	// 회원가입
	@PostMapping("/join")
	public ResponseEntity<String> join(User user, MultipartFile upload_file) throws Exception {
		int num = userService.chekId(user.getUserId());
		// 이미 아이디가 존재할때
		if (num == 0) {
			userService.join(user);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.CONFLICT);
	}

	// 회원정보 수정
	@PutMapping("/user")
	public ResponseEntity<String> modify(User user) {
		userService.modifyUser(user);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	// 회원 탈퇴
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> delete(@PathVariable String userId) {
		// dropUser가 가능하면
		if (userService.dropUser(userId)) {
			userService.dropUser(userId);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	// 회원 조회
	@GetMapping("/user")
	public ResponseEntity<List<User>> searchUser(@RequestParam(defaultValue = "") String keyword) {
		return new ResponseEntity<List<User>>(userService.getUserList(keyword), HttpStatus.OK);
	}
}
