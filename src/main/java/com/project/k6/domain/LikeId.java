package com.project.k6.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial") // 직렬화 관련 경고를 억제해줌.
@Getter
@NoArgsConstructor
@AllArgsConstructor
//LIke테이블에 @id를 여러개 사용할 수 있도록 만들어주는 클래스, 복합키를 정의하기 위해 likeid를 사용함.
public class LikeId implements Serializable { //implements Serializable = 두 태이블이 직열화(다대다)가 가능하게 만들어줌. 
    private Long member;
    private String hsCode;

    // default constructor, equals, and hashCode methods
}