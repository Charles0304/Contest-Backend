package com.project.k6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.k6.domain.HsCode;
import com.project.k6.dto.HsCodeDTO;
import com.project.k6.persistence.HsCodeRepository;

@Service
public class HsCodeService {

	@Autowired
	private HsCodeRepository hscodeRepo;

	public List<HsCode> getHsCodes() {
		return hscodeRepo.findAll();
	}

	public List<HsCode> getMajorCategories(int hscode1) {
		return hscodeRepo.findByHscode1(hscode1);
	}

	public List<HsCode> getMediumCategoriesByMajor(int hscode1, int hscode2) {
		return hscodeRepo.findByHscode1AndHscode2(hscode1, hscode2);
	}

	public List<HsCode> getMinorCategoriesByMajorAndMedium(int hscode1, int hscode2, int hscode3) {
		return hscodeRepo.findByHscode1AndHscode2AndHscode3(hscode1, hscode2, hscode3);
	}
	
	public List<HsCodeDTO> getCategoires(){
		return hscodeRepo.findCategories();
	}
}