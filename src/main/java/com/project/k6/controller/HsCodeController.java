package com.project.k6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.project.k6.domain.HsCode;
import com.project.k6.service.HsCodeService;

@Controller
public class HsCodeController {
	
	@Autowired
	private HsCodeService hscodeService;
	
	public List<HsCode> getHsCodes(){
		return hscodeService.getHsCodes();
	}
}
