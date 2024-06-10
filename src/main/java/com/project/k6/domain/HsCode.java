package com.project.k6.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private int hscode;
    private String koreanItem;
    private String englishItem;
    private int classificationCode;
    private String classificationCodeName;
    private String dsc;

    @ManyToOne
    @JoinColumn(name = "descript_major_category")
    private Descript descript;

    // getters and setters
}