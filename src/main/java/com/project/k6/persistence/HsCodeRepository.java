package com.project.k6.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.k6.domain.HsCode;

public interface HsCodeRepository extends JpaRepository<HsCode, String> {

	 List<HsCode> findByHscode1(int hscode1);
	 List<HsCode> findByHscode1AndHscode2(int hscode1, int hscode2);
	 List<HsCode> findByHscode1AndHscode2AndHscode3(int hscode1, int hscode2, int hscode3);
}
