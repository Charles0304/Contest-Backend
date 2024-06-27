package com.project.k6.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//hscode에 대, 중, 소 코드만 받아오는 클래스
//String으로 선언한 이유는 대분류에서 0101로 넘어와야 하는데 int로 받으면 101로 넘어와서 String으로 받은 뒤에 밑에서 int로 변환.
//DTO(data transfer object)
public class HsCodeDTO {
	private String hscode1;
	private String hscode2;
	private String hscode3;
	
	public HsCodeDTO(int hscode1, int hscode2, int hscode3) {
		this.hscode1=Integer.toString(hscode1);
		this.hscode2=Integer.toString(hscode2);
		this.hscode3=Integer.toString(hscode3);
	}
}
