package com.ssafy.ownmate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.ownmate.interceptor.JWTInterceptor;


@Configuration
@EnableWebMvc
public class WebConfig  implements WebMvcConfigurer{
	//모든 url CORS문제 해결
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*")
		.allowedMethods("GET","POST","PUT","DELETE")
		.maxAge(6000);
	}
	//swagger 사용하는 config
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
	}
	
	//interceptor등록
	@Autowired
	private JWTInterceptor jwtInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor)
		//모든요청을 다 검사해
		.addPathPatterns("/**")
		//api/login으로 들어오는것만 빼고
		.excludePathPatterns("/api/login");
	}
	
}