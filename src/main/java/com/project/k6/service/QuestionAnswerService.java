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

        return questions.stream().map(question -> {
            QuestionAnswerDTO.QuestionAnswerDTOBuilder dtoBuilder = QuestionAnswerDTO.builder()
                .questionSeq(question.getSeq())
                .questionTitle(question.getTitle())
                .questionContent(question.getContent())
                .questionAuthor(question.getMember().getUsername()) // assuming Member has a getName() method
                .questionDate(question.getCreatedDate());

            if (question.getAnswerBoard() != null) {
                dtoBuilder.answerTitle(question.getAnswerBoard().getTitle())
                          .answerContent(question.getAnswerBoard().getContent())
                          .answerDate(question.getAnswerBoard().getCreatedDate());
            }

            return dtoBuilder.build();
        }).collect(Collectors.toList());
    }
}