package com.project.k6.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HsCodeDTO {
	private int hscode1;
	private int hscode2;
	private int hscode3;
	
	public HsCodeDTO(int hscode1, int hscode2, int hscode3) {
		this.hscode1=hscode1;
		this.hscode2=hscode2;
		this.hscode3=hscode3;
	}
}
