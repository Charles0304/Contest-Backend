package com.project.k6.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.k6.domain.HsCode;
import com.project.k6.dto.HsCodeDTO;

public interface HsCodeRepository extends JpaRepository<HsCode, String> {

	 List<HsCode> findByHscode1(int hscode1);
	 List<HsCode> findByHscode1AndHscode2(int hscode1, int hscode2);
	 List<HsCode> findByHscode1AndHscode2AndHscode3(int hscode1, int hscode2, int hscode3);
	 @Query("SELECT new com.project.k6.dto.HsCodeDTO(c.hscode1, c.hscode2, c.hscode3) FROM HsCode c")
	 List<HsCodeDTO> findCategories();
}
