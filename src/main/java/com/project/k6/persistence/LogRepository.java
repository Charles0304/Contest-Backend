package com.project.k6.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.k6.domain.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

}
