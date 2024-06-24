package com.project.k6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.k6.domain.Member;
import com.project.k6.persistence.MemberRepository;

import jakarta.persistence.EntityNotFoundException;




@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Member registerUser1(Member member) {
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		return memberRepository.save(member);
	}
	
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
    
    //member객체를 반환시키는 메서드
    //memberRepo에서 id기반으로 member객체를 조회한다.
    //orElseThrow(() -> new EntityNotFoundException("Member not found")) => Optional에 값이 존재하지 않을 경우, 즉 findById(id)가 빈 Optional을 반환활 경우 예외를 던진다.
    //
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Member not found"));
    }
}
