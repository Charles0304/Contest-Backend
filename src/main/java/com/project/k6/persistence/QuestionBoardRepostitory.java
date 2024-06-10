package com.project.k6.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.k6.domain.QuestionBoard;

public interface QuestionBoardRepostitory extends JpaRepository<QuestionBoard, Long> {

}
