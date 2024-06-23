package com.project.k6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.k6.domain.Log;
import com.project.k6.domain.Member;
import com.project.k6.service.LogService;
import com.project.k6.service.MemberService;


@RestController
@RequestMapping("/api")
public class LogConrtoller {
	@Autowired
	private LogService logService;
	@Autowired
	private MemberService memberService;

	@PostMapping("/process")
	public Log sendToFlask(@RequestBody String inputText, String id) throws JsonProcessingException {
		return logService.insertLog(inputText, id);
	}

	//모든 로그 다 가져오기
	@GetMapping("/loglist")
	public List<Log> getLogList() {
		return logService.getLogLists();
	}

	//맴버에 대한 log 불러오기
	@GetMapping("/member/{memberId}")
	public List<Log> getLogsByMember(@PathVariable Long memberId) {
		Member member = memberService.getMemberById(memberId); // MemberService를 사용하여 Member 조회
		return logService.getLogsByMember(member);
	}
}
