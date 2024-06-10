package com.project.k6;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.k6.domain.Member;
import com.project.k6.domain.Role;
import com.project.k6.persistence.MemberRepository;

@SpringBootTest
public class MemberTest {
	PasswordEncoder encoder = new BCryptPasswordEncoder();
	@Autowired
	MemberRepository memberRepo;
	@Test
	public void addMember() {
		Member test = Member.builder()
		.email("cotncjf2@naver.com")
		.password(encoder.encode("1234"))
		.username("cotncjf")
		.role(Role.ROLE_ADMIN)
		.build();
		memberRepo.save(test);
	}
	
}
