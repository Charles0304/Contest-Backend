package com.project.k6.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.k6.domain.Log;
import com.project.k6.domain.Member;

public interface LogRepository extends JpaRepository<Log, Long> {
	List<Log> findByMember(Member member);
}
