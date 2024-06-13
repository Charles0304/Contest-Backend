package com.project.k6.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hscode")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HsCode {
	
    @Id
    private String hscode;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long seq;
    private int hscode1;
    private int hscode2;
    private int hscode3;
    @Column(columnDefinition = "TEXT")
    private String hs1englishitem;
    @Column(columnDefinition = "TEXT")
    private String hs1koreanitem;
    @Column(columnDefinition = "TEXT")
    private String hs2englishitem;
    @Column(columnDefinition = "TEXT")
    private String hs3englishitem;
    @Column(columnDefinition = "TEXT")
    private String hs3koreanitem;
    private int classificationcode;
    private String classificationcodename;
    private String img;
}