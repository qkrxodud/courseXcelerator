package com.courseXcelerator.courseXcelerator.core.domain.crawler;

import com.courseXcelerator.courseXcelerator.storage.jpa.CourseJpaEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Courses {
    private final List<Course> coursesList;

    public Courses(List<Course> inflearnCrawlerList) {
        this.coursesList = inflearnCrawlerList;
    }

    public List<CourseJpaEntity> toJapEntities() {
        return coursesList.stream()
                .map(courses -> CourseJpaEntity.of(courses))
                .collect(Collectors.toList());
    }
}
