package com.project.k6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.k6.domain.AnswerBoard;
import com.project.k6.domain.QuestionBoard;
import com.project.k6.persistence.AnswerBoardRepository;
import com.project.k6.persistence.QuestionBoardRepository;

@Service
public class AnswerBoardService {

	@Autowired
	private AnswerBoardRepository answerBoardRepository;
	@Autowired
	private QuestionBoardRepository questionBoardRepository;
	@Autowired
	private QuestionBoardService questionBoardService;

	public List<AnswerBoard> getBoards() {
		return answerBoardRepository.findAll();
	}

	public AnswerBoard saveAnswer(AnswerBoard answerBoard) {
		// 기존 QuestionBoard를 가져오기
        QuestionBoard questionBoard = questionBoardService.findById(answerBoard.getQuestionBoard().getSeq());

        // AnswerBoard 저장
        answerBoard.setQuestionBoard(questionBoard);
        AnswerBoard savedAnswer = answerBoardRepository.save(answerBoard);

        // 관련된 QuestionBoard의 상태를 업데이트
        questionBoard.setAnswered(true);
        questionBoardRepository.save(questionBoard);

        return savedAnswer;
	}

	public AnswerBoard putBoards(AnswerBoard answerboard) {
		answerBoardRepository.save(answerboard);
		return answerboard;
	}

	public AnswerBoard deleteBoards(Long seq) {
		AnswerBoard ab = answerBoardRepository.getById(seq);
		answerBoardRepository.deleteById(seq);
		return ab;
	}
}
