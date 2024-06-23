package com.project.k6.domain;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor // 기본 생성자 만들어줌, 원래 자바에서 기본생성자를 만들어주는데 @AllArgsConstructor랑, 빌더랑 빌더 어노테이션에서 생성자를 만들어주고 있어서 기본 성생자가 만들어지지않아 이걸 씀.
@AllArgsConstructor // 모든 필드의 변수를 포함한 생성자를 만들어줌
@Builder // 테이블에 값을 넣어주는 역할 원래는 set을 써서 해야함.
@ToString
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	@Column(nullable=false,unique=true) //nullable=false = 널이 있으면 안되니까 널이 있으면 오류가 뜨게 해줌, unique=true = 중복된 이메일이 있으면 안되니 중복이 안되게 만들어줌., 이 어노테이션을 사용한 필드값은 중복이 되어선 안됨을 의미함.  
	private String email;
	private String password;
	private Role role; // 시큐리티(권한)에 쓰기 위한 용도

	//member 하나가 여러개의 log를 가질 수 있다.
	@OneToMany(mappedBy = "member")//부모의 테이블 이름을 적어서 연결(대,소문자는 구분안함), 그리고 자식테이블에는 joincolume을 써서 부모의 테이블의 값과 연결시킴.
	private Set<Log> logs; // 회원 정보를 검색했을 때 로그도 나오게 함
}
