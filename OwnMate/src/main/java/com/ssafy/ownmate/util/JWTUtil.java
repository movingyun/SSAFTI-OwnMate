package com.ssafy.ownmate.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
//	SALT라는 비밀키 생성
	private static final String SALT ="SSAFIT";
	
	//토큰 생성
	public String createToken(String claimId, String data) throws UnsupportedEncodingException {
		return Jwts.builder()
				//헤더정보입력
				.setHeaderParam("alg", "HS256")
				.setHeaderParam("typ", "JWT")
				//페이로드 입력
				.claim(claimId, data)
//				유효성 시간 3초 설정
//				.setExpiration(new Date(System.currentTimeMillis()+3000))
				//서명하고 compact해서 문자열로 만들어
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8"))
				.compact();
	}
	
	//토큰 검증
	public void checkToken(String token) throws Exception {
		Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(token);
	}
	
	
	
	
}
