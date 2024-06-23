package com.project.k6.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.k6.domain.Like;
import com.project.k6.domain.LikeId;
import com.project.k6.domain.Member;

public interface LikeRepostitory extends JpaRepository<Like,LikeId> {
    List<Like> findByMember(Member member);

}
