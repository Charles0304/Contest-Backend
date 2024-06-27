package com.project.k6.dto;

import com.project.k6.domain.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//프론트로 보낼 때 비밀번호까지 보내는게 좀 그렇다 싶어서 이 테이블을 따로 만듦.
public class MemberDTO {
	private Long id;
	private String username;
	private String email;
	private Role role;
}