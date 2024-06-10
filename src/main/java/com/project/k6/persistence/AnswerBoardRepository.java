package com.project.k6.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.k6.domain.AnswerBoard;

public interface AnswerBoardRepository extends JpaRepository<AnswerBoard, Long> {

}
