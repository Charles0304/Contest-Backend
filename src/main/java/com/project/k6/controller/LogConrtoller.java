package com.project.k6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.k6.domain.Member;
import com.project.k6.service.MemberService;

@RestController
@RequestMapping("/api/users")
public class LogConrtoller {

	@Autowired
	private MemberService memberService;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Member member) {
		try {
			memberService.registerUser(member);
			return ResponseEntity.ok("User registered successfully");
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
