package com.project.k6.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member_like") //sql 쿼리문에서 테이블명과 쿼리가 곂치는 것을 방지하기 위해 이름이 곂치는 클래스 명을 다른 이름으로 지정해주는 어노테이션
@IdClass(LikeId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//member랑 hccode테이블의 jointable임. 이 테이블은 manytomany 어노테이션을 쓰면 자동으로 만들어줌.
public class Like {
	
	//id가 두개니까 LikeId테이블을 만들어서 한 테이블에 여러 아이디를 사용할 수 있게 해줌.
    @Id
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Id
    @ManyToOne
    @JoinColumn(name = "hscode_hscode")
    private HsCode hsCode;

}