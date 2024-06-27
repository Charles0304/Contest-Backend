package com.project.k6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.k6.domain.Member;
import com.project.k6.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/members")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody Member member) {
		if (memberService.findByUsername(member.getUsername()) != null) {
			return ResponseEntity.badRequest().body("Username is already taken");
		}
		memberService.registerUser(member);
		return ResponseEntity.ok("User registered successfully");
	}
}
