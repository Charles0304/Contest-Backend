package com.project.k6.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlaskService {
	
	//데이터를 JSON 객체로 변환하기 위해서 사용
    private final ObjectMapper objectMapper;
	//오브잭트로 받아오는 hscode를 배열로 받아오기 위한 메서드
    @Transactional // do all die
    public String[] sendToFlask(String dto) throws JsonProcessingException {
        
    	RestTemplate restTemplate = new RestTemplate();
		
        //헤더를 JSON으로 설정함
        HttpHeaders headers = new HttpHeaders();
        
        //파라미터로 들어온 dto를 JSON 객체로 변환
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        String param = objectMapper.writeValueAsString(dto);

        HttpEntity<String> entity = new HttpEntity<>(param , headers);
		
        //실제 Flask 서버랑 연결하기 위한 URL
        String url = "http://10.125.121.214:5000/process";
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        
        // JSON 응답을 파싱하여 숫자 배열로 변환
        JsonNode jsonNode = objectMapper.readTree(response.getBody());
        JsonNode resultNode = jsonNode.get("result");

        // JsonNode를 String[]로 변환
        String[] resultArray = objectMapper.convertValue(resultNode, String[].class);
        System.out.println(resultArray[0]);
        return resultArray;
    }
}
