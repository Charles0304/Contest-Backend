package com.project.k6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	//RestTemplate를 빈객체에 등록해서 사용려고 만든 클래스
    @Bean
    RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
