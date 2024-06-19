package com.project.k6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.k6.service.FlasktestService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private FlasktestService flaskService;

	@PostMapping("/process")
	public String sendToFlask(@RequestBody String inputText) throws JsonProcessingException {
		return flaskService.sendToFlask(inputText);
	}
}
