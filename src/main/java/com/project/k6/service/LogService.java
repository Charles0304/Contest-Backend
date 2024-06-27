package com.project.k6.service;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.k6.domain.HsCode;
import com.project.k6.domain.Log;
import com.project.k6.domain.Member;
import com.project.k6.persistence.HsCodeRepository;
import com.project.k6.persistence.LogRepository;
import com.project.k6.persistence.MemberRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LogService {

	@Autowired
	private FlaskService flaskService;

	@Autowired
	private HsCodeRepository hscodeRepo;

	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private LogRepository logRepo;

	public Set<HsCode> insertLog(String input, String id) throws JsonProcessingException {
		//input STring으로 플라스크에서 결과값을 받아온다 (배열)
		String[] result = flaskService.sendToFlask(input);
		//새로운 로그 생성
		Log newLog = new Log();
		//input data 입력
		newLog.setInputValue(input.substring(input.indexOf(":")+2, input.lastIndexOf('"')));
		//Member id 만 가져오는 방법
		Optional<Member> memberOptional = memberRepo.findById(Long.parseLong(id));
		Member member = memberOptional.orElseThrow(()->new EntityNotFoundException("member not found"));
		newLog.setMember(member);
		newLog.setCreatedDate(LocalDateTime.now());
		//결과를 돌면서 다 추가를 해준다
		Set<HsCode> hsCodeSet = new HashSet<>();
		for(String s : result ) {
			if(s.length()<10)
				s="0"+s;
			s=s.substring(0, 4)+"-"+s.substring(4,6)+"-"+s.substring(6);
			System.out.println(s);
			Optional<HsCode> hscodeOptional = hscodeRepo.findById(s);
			if(hscodeOptional.isPresent()) {
				HsCode hs = hscodeOptional.orElseThrow(() -> new EntityNotFoundException("HsCode not found"));
				hsCodeSet.add(hs);
			}
		}
		newLog.setHsCodes(hsCodeSet);
		logRepo.save(newLog);
		return hsCodeSet;
	}

	public List<Log> getLogLists() {
		return logRepo.findAll();
	}


	public List<Log> getLogsByMember(Member member) {
		return logRepo.findByMember(member);
	}
}
