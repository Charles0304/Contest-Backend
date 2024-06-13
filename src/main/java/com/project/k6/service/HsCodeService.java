package com.project.k6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.k6.domain.HsCode;
import com.project.k6.persistence.HsCodeRepository;

@Service
public class HsCodeService {

	@Autowired
	private HsCodeRepository hscodeRapo;

	public List<HsCode> getHsCodes() {
		return hscodeRapo.findAll();
	}

	public List<HsCode> getMajorCategories(int hscode1) {
		return hscodeRapo.findByHscode1(hscode1);
	}

	public List<HsCode> getMediumCategoriesByMajor(int hscode1, int hscode2) {
		return hscodeRapo.findByHscode1AndHscode2(hscode1, hscode2);
	}

	public List<HsCode> getMinorCategoriesByMajorAndMedium(int hscode1, int hscode2, int hscode3) {
		return hscodeRapo.findByHscode1AndHscode2AndHscode3(hscode1, hscode2, hscode3);
	}
}