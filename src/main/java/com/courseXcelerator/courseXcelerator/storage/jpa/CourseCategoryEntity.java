package com.courseXcelerator.courseXcelerator.storage.jpa;

import com.courseXcelerator.courseXcelerator.core.domain.crawler.CourseCategory;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "course_cateogry")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CourseCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "name")
    private String name;

    public CourseCategory toModel() {
        return CourseCategory.builder()
                .id(id)
                .companyId(companyId)
                .name(name)
                .build();
    }

}
