//package com.ssafy.ownmate.interceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import com.ssafy.ownmate.util.JWTUtil;
//
//
//@Component
////로그인 안하면 다른거 못쓰게 할라고 interpretor등록!!
////이걸 해준담에 WebConfig에 등록해줘야댐
//public class JWTInterceptor implements HandlerInterceptor{
//	private static final String HEADER_AUTH = "access-token";
//	
//	@Autowired
//	private JWTUtil jwtutil;
//	
////	preHandle = 요청이오면 처리하기전에 잡아다가 확인할꺼야
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		
//		//에러 2개 뜨는거 해소
//		if(request.getMethod().equals("OPTIONS")) {
//			return true;
//		}
//		
//		final String token = request.getHeader(HEADER_AUTH);
//		if(token != null) {
//			jwtutil.checkToken(token);
//			return true;
//		}
//		throw new Exception("유효하지않은 접근입니다");
//	}
//}
