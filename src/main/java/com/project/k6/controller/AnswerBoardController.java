package com.project.k6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.project.k6.domain.AnswerBoard;
import com.project.k6.domain.Member;
import com.project.k6.domain.QuestionBoard;
import com.project.k6.service.AnswerBoardService;


@Controller
public class AnswerBoardController {
	
	@Autowired
	private AnswerBoardService boardService;
	
	@GetMapping("/answerboard")
	public List<AnswerBoard> getBoards(AnswerBoard answerboard){
		return boardService.getBoards();
	}
	
	@PostMapping("/answerboard")
	public AnswerBoard postBoards(AnswerBoard answerboard) {
		QuestionBoard qboard = null;
		Member member = null;
		return boardService.postBoards(answerboard, qboard, member);
	}
	
	@PutMapping("/answerboard")
	public AnswerBoard putBoards(AnswerBoard answerboard) {
		return boardService.putBoards(answerboard);
	}

	@DeleteMapping("/board")
	public AnswerBoard deleteBoards(Long seq) {
		return boardService.deleteBoards(seq); 
	}
}
