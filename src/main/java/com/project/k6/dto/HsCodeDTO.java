package com.project.k6.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
