package com.project.k6.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.k6.domain.Like;
import com.project.k6.domain.LikeId;

public interface LikeRepostitory extends JpaRepository<Like,LikeId> {

}
