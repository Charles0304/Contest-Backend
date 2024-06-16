package com.project.k6.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionAnswerDTO {
    private Long questionSeq;
    private String questionTitle;
    private String questionContent;
    private String questionAuthor;
    private LocalDateTime questionDate;
    private String answerTitle;
    private String answerContent;
    private LocalDateTime answerDate;
}