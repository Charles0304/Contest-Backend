package com.project.k6.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.k6.domain.HsCode;

public interface HsCodeRepository extends JpaRepository<HsCode, Integer> {

}
