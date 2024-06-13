package com.project.k6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.k6.domain.HsCode;
import com.project.k6.service.HsCodeService;

@RestController
public class HsCodeController {

	@Autowired
	private HsCodeService hscodeService;

	@GetMapping("/codes")
	public List<HsCode> getHsCodes(){
		return hscodeService.getHsCodes();
	}

	@GetMapping("/major")
	public List<HsCode> getMajorCategories(int hscode1) {
		return hscodeService.getMajorCategories(hscode1);
	}

	@GetMapping("/major/medium")
	public List<HsCode> getMediumCategoriesByMajor(int hscode1, int hscode2) {
		return hscodeService.getMediumCategoriesByMajor(hscode1, hscode2);
	}

	@GetMapping("/major/medium/minor")
	public List<HsCode> getMinorCategoriesByMajorAndMedium(int hscode1, int hscode2, int hscode3) {
		return hscodeService.getMinorCategoriesByMajorAndMedium(hscode1, hscode2, hscode3);
	}

}
