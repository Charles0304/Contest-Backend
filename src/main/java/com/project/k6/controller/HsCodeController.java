package com.project.k6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.k6.domain.HsCode;
import com.project.k6.dto.HsCodeDTO;
import com.project.k6.service.HsCodeService;

@RestController
@RequestMapping("/hscode")
public class HsCodeController {

	@Autowired
	private HsCodeService hsCodeService;

	@GetMapping("/all")
	public List<HsCode> getHsCodes() {
		return hsCodeService.getHsCodes();
	}

	@GetMapping("/major")
	public List<HsCode> getMajorCategories(int hscode1) {
		return hsCodeService.getMajorCategories(hscode1);
	}

	@GetMapping("/medium")
	public List<HsCode> getMediumCategoriesByMajor(int hscode1, int hscode2) {
		return hsCodeService.getMediumCategoriesByMajor(hscode1, hscode2);
	}

	@GetMapping("/minor")
	public List<HsCode> getMinorCategoriesByMajorAndMedium(int hscode1, int hscode2, int hscode3) {
		return hsCodeService.getMinorCategoriesByMajorAndMedium(hscode1, hscode2, hscode3);
	}

	@GetMapping("/categories")
	public List<HsCodeDTO> getCategories() {
		return hsCodeService.getCategoires();
	}

	@GetMapping("/random-hscodes")
	public List<HsCode> getRandomHsCodes() {
		return hsCodeService.getRandomHsCodes();
	}
}
