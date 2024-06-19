package com.project.k6.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.k6.domain.HsCode;
import com.project.k6.domain.Log;
import com.project.k6.domain.Member;
import com.project.k6.persistence.HsCodeRepository;
import com.project.k6.persistence.LogRepository;

@Service
public class LogService {
	
    @Autowired
    private MemberService memberService;
    
    @Autowired
    private FlasktestService flaskService;
    
    @Autowired
    private HsCodeRepository hscodeRepo;
    
    @Autowired
    private LogRepository logRepo;
    
    public Log insertLog(String input, Member member) throws JsonProcessingException {
    	//input STring으로 플라스크에서 결과값을 받아온다 (배열)
    	String[] result = flaskService.sendToFlask(input);
    	//새로운 로그 생성
    	Log newLog = new Log();
    	//input data 입력
    	newLog.setInputValue(input);
    	//사용자가 누군지 입력 지금은 입력값이 member객체로 이메일로 넘어올수도 있음
    	//Member member = memberRepo.getMemberByID(id);
    	newLog.setMember(member);
    	//결과를 돌면서 다 추가를 해준다
    	for(String s : result ) {
    		HsCode hs = hscodeRepo.getById(s);
    		newLog.getHsCodes().add(hs);
    	}
    	logRepo.save(newLog);
    	return newLog;
    }
}
