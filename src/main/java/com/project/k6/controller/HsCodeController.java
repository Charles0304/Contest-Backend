package com.project.k6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
