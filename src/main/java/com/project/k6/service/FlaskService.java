package com.project.k6.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FlaskService {

	@Autowired
	private RestTemplate restTemplate;

    public String sendToFlask(String inputTextDto) {
        String url = "http://10.125.121.214:5000/process"; //외부 API URL
        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 요청 바디 설정
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("inputTextDto", inputTextDto);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
        try {
            // 외부 API에 POST 요청 보내기
            ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
            System.out.println("ok");

            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            } else {
                throw new RuntimeException("Failed to get data: " + response.getStatusCode());
            }
        } catch (RestClientException e) {
            String errorMsg = "Error accessing the external API: " + e.getMessage();
            log.error(errorMsg, e);
            throw new RuntimeException(errorMsg, e);
        }


    }
}