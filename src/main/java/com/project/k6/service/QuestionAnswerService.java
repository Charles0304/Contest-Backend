package com.project.k6.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.k6.domain.QuestionBoard;
import com.project.k6.dto.QuestionAnswerDTO;
import com.project.k6.persistence.QuestionBoardRepository;

@Service
public class QuestionAnswerService {

    @Autowired
    private QuestionBoardRepository questionBoardRepository;

    public List<QuestionAnswerDTO> getAllQuestionsWithAnswers() {
        List<QuestionBoard> questions = questionBoardRepository.findAll();
        
        //답변이 없으면 if문은 실행이 안된 채 프론트로 넘어가고 나머지 값(answer값)은 null이 되며 이는 프론트에서 "답변이 안되었음"을 표시해줌
        //답변이 있는 경우 if문이 실행된 채 build가 되어 프론트로 넘어감. 프론트에서는 답변완료만 체크해줌.
        return questions.stream().map(question -> {
        	//QuestionAnswerDTO에 있는 값을 가져오는 방법
            QuestionAnswerDTO.QuestionAnswerDTOBuilder dtoBuilder = QuestionAnswerDTO.builder() //QuestionAnswerDTOBuilder = 하나의 빌더 뿐만아니라 다른 조건도 추가할 수 있도록 해줌.
                .questionSeq(question.getSeq())
                .questionTitle(question.getTitle())
                .questionContent(question.getContent())
                .questionAuthor(question.getMember().getUsername()) // assuming Member has a getName() method
                .questionDate(question.getCreatedDate());
            //AnswerBoard에 있는 값을 가져오는 방법
            if (question.getAnswerBoard() != null) {
                dtoBuilder.answerTitle(question.getAnswerBoard().getTitle())
                          .answerContent(question.getAnswerBoard().getContent())
                          .answerDate(question.getAnswerBoard().getCreatedDate());
            }
            return dtoBuilder.build();
        }).collect(Collectors.toList());
    }
}