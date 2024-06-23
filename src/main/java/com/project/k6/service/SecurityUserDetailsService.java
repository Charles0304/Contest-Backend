package com.project.k6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.k6.domain.Member;
import com.project.k6.persistence.MemberRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService{
	@Autowired private MemberRepository memRepo;
	
	@Override	// AuthenticationManager의 authenticate 메소드가 호출되면 실행
	//로그인 할 떄 이메일 보내면 해당 이메일이랑 비밀번호가 일치한지 확인하는 메소드
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Member member = memRepo.findByEmail(email)
							.orElseThrow(()->new UsernameNotFoundException("Not Found!"));
		
		return new User(member.getEmail(), member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}
}