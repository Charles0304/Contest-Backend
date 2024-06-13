package com.project.k6.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.k6.domain.QuestionBoard;

public interface QuestionBoardRepository extends JpaRepository<QuestionBoard, Long> {

}
