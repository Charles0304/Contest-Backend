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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memRepo.findByEmail(username)
							.orElseThrow(()->new UsernameNotFoundException("Not Found!"));
		
		return new User(member.getEmail(), member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));
	}
}