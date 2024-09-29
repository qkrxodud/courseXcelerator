package com.courseXcelerator.courseXcelerator.core.domain.crawler;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Company {
    private Long id;
    private String name;

    @Builder
    public Company(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
