package com.project.k6.config;

import java.io.IOException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.k6.MemberDTO;
import com.project.k6.domain.Member;
import com.project.k6.persistence.MemberRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	// 인증 객체
	private final AuthenticationManager authenticationManager;
	private final MemberRepository memberRepository;
	
	// POST/Login 요청이 왔을 때 인증을 시도하는 메소드
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// request에서 json타입의 [username/password]를 읽어서 Member 객체를 생성한다.
		ObjectMapper mapper = new ObjectMapper();
		Member member = null;
		
		try {
			member = mapper.readValue(request.getInputStream(),Member.class);
			System.out.println(member);
			// Security에게 로그인 요처에 필요한 객체 생성
			Authentication authToken = new UsernamePasswordAuthenticationToken(member.getEmail(), member.getPassword());
			
			// 인증 진행 -> UserDetailService를 상속받은 클래스의 loadUserByUsername 호출한다.
			Authentication auth = authenticationManager.authenticate(authToken);
			System.out.println("auth: "+auth);
			return auth;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		return null;
	}
	
	// 인증이 성공했을 때 실행되는 후처리 메소드
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// 인증 결과 생성된 Authentication 객체에서 필요한 정보를 읽어서 토큰을 만들어서 헤더에 추가
		User user = (User)authResult.getPrincipal();
		String token = JWT.create()
						.withExpiresAt(new Date(System.currentTimeMillis()+1000*600*100))	// 토근 유효기간이 10분
						.withClaim("username", user.getUsername())
						.sign(Algorithm.HMAC256("edu.pnu.jwt"));
		// 응답 헤더에 추가
		response.addHeader("Authorization", "Bearer " + token);
		
		Member member = memberRepository.findByEmail(user.getUsername()).get();
		MemberDTO memberDTO = MemberDTO.builder()
				.username(member.getUsername())
				.email(member.getEmail())
				.role(member.getRole())
				.id(member.getId())
				.build();
		
		// 응답 본문에 닉네임 정보를 JSON 형식으로 추가
        ObjectMapper objectMapper = new ObjectMapper();
        String responseBody = objectMapper.writeValueAsString(memberDTO);

        // 응답 본문에 JSON 데이터 전송
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseBody);
	
		response.setStatus(HttpStatus.OK.value());
	}
}