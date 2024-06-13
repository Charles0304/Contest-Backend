package com.project.k6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.k6.domain.QuestionBoard;
import com.project.k6.persistence.QuestionBoardRepository;

@Service
public class QuestionBoardService {
	
	@Autowired
	private QuestionBoardRepository qbRapo;
	
	public List<QuestionBoard> getBoards(){
		return qbRapo.findAll();
	}

	public QuestionBoard putBoards(QuestionBoard questionBoard) {
		qbRapo.save(questionBoard);
		return questionBoard;
	}

	public QuestionBoard deleteBoards(Long seq) {
		QuestionBoard ab = qbRapo.getById(seq);
		qbRapo.deleteById(seq);
		return ab;
	}
}
