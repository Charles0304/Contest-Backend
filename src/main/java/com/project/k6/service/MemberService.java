package com.project.k6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.k6.domain.Member;
import com.project.k6.persistence.HsCodeRepository;
import com.project.k6.persistence.MemberRepository;




@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	public Member registerUser(Member member) {
//		member.setPassword(passwordEncoder.encode(member.getPassword()));
//		return memberRepository.save(member);
//	}
	
	public Member findByUsername(String username) {
		return memberRepository.findByUsername(username).orElse(null);
	}

    public Member registerUser(Member member) {
        if (memberRepository.findByUsername(member.getUsername()) != null) {
            throw new RuntimeException("Username is already taken");
        }
        if (memberRepository.findByEmail(member.getEmail()) != null) {
            throw new RuntimeException("Email is already taken");
        }
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        return memberRepository.save(member);
    }
}
