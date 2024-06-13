package com.project.k6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.project.k6.domain.QuestionBoard;
import com.project.k6.service.QuestionBoardService;


@Controller
public class QuestionBoardController {
	
	@Autowired
	private QuestionBoardService questionboardService;
	
	@GetMapping("/questionboard")
	public List<QuestionBoard> getBoards(QuestionBoard questionBoard){
		return questionboardService.getBoards();
	}
	
	@PutMapping("/questionboard")
	public QuestionBoard putBoards(QuestionBoard questionBoard) {
		return questionboardService.putBoards(questionBoard);
	}
	
	@DeleteMapping("/questionboard")
	public QuestionBoard deleteBoards(Long seq) {
		return questionboardService.deleteBoards(seq); 
	}
}
