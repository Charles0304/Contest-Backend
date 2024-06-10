package com.project.k6.domain;

import java.util.Set;

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

@Entity
@Table(name = "descript")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Descript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String majorCategory;
    private String mediateCategory;
    private String smallCategory;
    private String korean;
    private String english;

    @OneToMany(mappedBy = "descript")
    private Set<HsCode> hsCodes;

    // getters and setters
}