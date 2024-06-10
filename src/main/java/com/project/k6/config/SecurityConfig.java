package com.project.k6.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

import com.project.k6.persistence.MemberRepository;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;
	@Autowired
	private MemberRepository memberRepository;
	
	 @Bean
	 PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
	 
	 @Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 http.csrf(csrf->csrf.disable());
		 
		 http.authorizeHttpRequests(auth->auth
				 .requestMatchers("/user/profile/**").hasAnyRole("USER", "ADMIN")
				 .anyRequest().permitAll());
		 
		 http.formLogin(frmLogin -> frmLogin.disable());
		 http.httpBasic(basic->basic.disable());
		 
		 http.sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		 
		 http.addFilter(new JWTAuthenticationFilter(authenticationConfiguration.getAuthenticationManager(), memberRepository));
		 
		 // 스프링 시큐리티가 등록한 필터들 중에서 AuthorizationFilter 앞에 앞에서 작성한 필터를 삽입한다.
		 http.addFilterBefore(new JWTAuthorizationFilter(memberRepository), AuthorizationFilter.class);
		 return http.build();
	 }
}