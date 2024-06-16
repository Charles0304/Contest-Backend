package com.project.k6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.k6.dto.QuestionAnswerDTO;
import com.project.k6.service.QuestionAnswerService;

@RestController
@RequestMapping("/api")
public class QuestionAnswerController {

    @Autowired
    private QuestionAnswerService questionAnswerService;

    @GetMapping("/questions-answers")
    public List<QuestionAnswerDTO> getAllQuestionsWithAnswers() {
        return questionAnswerService.getAllQuestionsWithAnswers();
    }
}