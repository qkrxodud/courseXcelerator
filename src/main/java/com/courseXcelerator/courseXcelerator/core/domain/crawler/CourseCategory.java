package com.courseXcelerator.courseXcelerator.core.domain.crawler;


import lombok.Builder;
import lombok.Getter;

@Getter
public class CourseCategory {
    private Long id;

    private Long companyId;

    private String name;

    @Builder
    public CourseCategory(Long id, Long companyId, String name) {
        this.id = id;
        this.companyId = companyId;
        this.name = name;
    }
}
