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

import com.project.k6.domain.AnswerBoard;
import com.project.k6.service.AnswerBoardService;


@Controller
@RequestMapping("/api")
public class AnswerBoardController {
	
	@Autowired
	private AnswerBoardService answerBoardService;
	
	@GetMapping("/answers")
	public List<AnswerBoard> getBoards(AnswerBoard answerboard){
		return answerBoardService.getBoards();
	}
	
	@PostMapping("/answers")
    public AnswerBoard createAnswer(@RequestBody AnswerBoard answerBoard) {
        return answerBoardService.saveAnswer(answerBoard);
    }
	
	@PutMapping("/answers")
	public AnswerBoard putBoards(AnswerBoard answerboard) {
		return answerBoardService.putBoards(answerboard);
	}
	
	@DeleteMapping("/answers")
	public AnswerBoard deleteBoards(Long seq) {
		return answerBoardService.deleteBoards(seq); 
	}
}
