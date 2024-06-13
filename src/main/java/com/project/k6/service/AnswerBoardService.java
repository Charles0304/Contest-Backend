package com.project.k6.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.k6.domain.AnswerBoard;
import com.project.k6.domain.Member;
import com.project.k6.domain.QuestionBoard;
import com.project.k6.persistence.AnswerBoardRepository;

@Service
public class AnswerBoardService {
	
	@Autowired
	private  AnswerBoardRepository abRapo;
	
	public List<AnswerBoard> getBoards(){
		return abRapo.findAll();
	}
	
	public AnswerBoard postBoards(AnswerBoard answerboard, QuestionBoard qboard, Member member){
		qboard.setAnswered(true);
		qboard.setAnswerBoard(answerboard);
		answerboard.setQuestionBoard(qboard);
		answerboard.setMember(member);
		abRapo.save(answerboard);
		return answerboard;
	}

	public AnswerBoard putBoards(AnswerBoard answerboard) {
		abRapo.save(answerboard);
		return answerboard;
	}

	public AnswerBoard deleteBoards(Long seq) {
		AnswerBoard ab = abRapo.getById(seq);
		abRapo.deleteById(seq);
		return ab;
	}
}
