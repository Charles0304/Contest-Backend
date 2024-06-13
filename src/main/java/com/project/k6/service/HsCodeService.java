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
	
}
