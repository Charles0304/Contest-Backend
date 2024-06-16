package com.project.k6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.k6.domain.QuestionBoard;
import com.project.k6.service.QuestionBoardService;


@Controller
@RequestMapping("api")
public class QuestionBoardController {
	
	@Autowired
	private QuestionBoardService questionBoardService;
	
	@PostMapping("/questions")
    public QuestionBoard createQuestion(@RequestBody QuestionBoard questionBoard) {
        return questionBoardService.saveQuestion(questionBoard);
    }
	
	@GetMapping("/questionboard")
	public List<QuestionBoard> getBoards(QuestionBoard questionBoard){
		return questionBoardService.getBoards();
	}
	
	@PutMapping("/questionboard")
	public QuestionBoard putBoards(QuestionBoard questionBoard) {
		return questionBoardService.putBoards(questionBoard);
	}
	
	@DeleteMapping("/questionboard")
	public QuestionBoard deleteBoards(Long seq) {
		return questionBoardService.deleteBoards(seq); 
	}
}
