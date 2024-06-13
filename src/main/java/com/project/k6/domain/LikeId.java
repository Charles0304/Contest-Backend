package com.project.k6.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LikeId implements Serializable {
    private Long member;
    private String hsCode;

    // default constructor, equals, and hashCode methods
}