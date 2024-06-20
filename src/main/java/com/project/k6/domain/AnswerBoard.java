package com.project.k6.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "answerboard")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private String title; // nullable(fales)추천
    private String content;

    @CreatedDate // 생성된 날짜
    @Column(updatable = false) // 만들어진 시간은 바꿀 수 없으니 업데이트를 못하게 만들어줌.
    private LocalDateTime createdDate;
    
    @OneToOne // 질문글이 하나면 대답글이 하나고, 대답글이 하나면 질문글이 하나이니까.
    @JoinColumn(name = "questionboard_seq")
    private QuestionBoard questionBoard;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @PrePersist // 데이터베이스에 저장되기 전 특수 동작을 시행키켜줌.
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }
}