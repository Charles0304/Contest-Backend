package com.project.k6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.k6.domain.Log;
import com.project.k6.domain.Member;
import com.project.k6.service.LogService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private LogService logService;

	@PostMapping("/process")
	public Log sendToFlask(@RequestBody String inputText, Member member) throws JsonProcessingException {
		return logService.insertLog(inputText, member);
	}
}