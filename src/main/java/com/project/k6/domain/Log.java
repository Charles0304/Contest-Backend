package com.project.k6.domain;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @Column(columnDefinition = "TEXT")
    private String inputValue;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "member_id") // mamber 의 필드인 id랑 연결됨.
    private Member member;

    @ManyToMany // log 에서는 hscode 테이블 정보가 필요하지만 hscode 테이블에서는 log 테이블 정보가 필요없어서 hscode 테이블에서는 many to many 어노테이션을 사용하지 않음.
    @JoinTable(
        name = "log_hscode", // jointable 의 이름
        joinColumns = @JoinColumn(name = "log_id"), //log 테이블(이쪽)의 id 를 필드값으로 넣겠다. 
        inverseJoinColumns = @JoinColumn(name = "hscode_hscode") //hscode 테이블(저쪽)의 hscode 를 필드값으로 넣겠다.
    )
    //Set 순서는 상관없지만 중복된 값이 없도록 해줌. => 이로 인해서 결과값으로 중복된 hscode값이 안나오는 거임. (list, map, set) 이 있음.
    private Set<HsCode> hsCodes;
}
