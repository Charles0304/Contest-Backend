package com.project.k6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.k6.domain.QuestionBoard;
import com.project.k6.persistence.QuestionBoardRepository;

@Service
public class QuestionBoardService {
	
	@Autowired
	private QuestionBoardRepository questionBoardRepository;
	
	public QuestionBoard findById(Long id) {
        return questionBoardRepository.findById(id).orElseThrow(() -> new RuntimeException("QuestionBoard not found"));
    }
	
	public QuestionBoard saveQuestion(QuestionBoard questionBoard) {
        return questionBoardRepository.save(questionBoard);
    }
	
	public List<QuestionBoard> getBoards(){
		return questionBoardRepository.findAll();
	}

	public QuestionBoard putBoards(QuestionBoard questionBoard) {
		questionBoardRepository.save(questionBoard);
		return questionBoard;
	}

	public QuestionBoard deleteBoards(Long seq) {
		QuestionBoard ab = questionBoardRepository.getById(seq);
		questionBoardRepository.deleteById(seq);
		return ab;
	}
}
