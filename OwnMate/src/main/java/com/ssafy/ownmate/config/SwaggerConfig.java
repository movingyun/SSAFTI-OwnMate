package com.ssafy.ownmate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	//Docket=스웨거의 설정정보를 갖고있는애로 약속되어있음!
	@Bean
	public Docket api() {
		//select() = 내가 만든것만 보여줄거야
		//OAS(open api source)_30 = 화면에 보이는 문서의 종류
		return new Docket(DocumentationType.OAS_30)
				// ApiSelectorBuiler를 통해 기준을 선택한다.
				.select()
				//경로에 있는것만 등록해줘(클래스 기준으로 제한을 둠)~~
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.ownmate.controller"))
				//호출하는 Uri기준을 제한(controller 패키지 아래 api로 시작하는애들)
				.paths(PathSelectors.ant("/api/**"))
				//위에 설정들로 docket을 만들어~~
				.build()
				//위에 글들 바꾸자~~
				.apiInfo(apiInfo());
	}
	
	//위에 글들 바꾸는걸 함수로 만들어둠
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("OwnMate Swagger")
				.description("SSAFIT 최종 API테스트")
				.version("1.0")
				.build();
	}
}





