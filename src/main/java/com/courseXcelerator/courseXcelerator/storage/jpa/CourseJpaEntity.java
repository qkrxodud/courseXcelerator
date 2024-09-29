package com.courseXcelerator.courseXcelerator.storage.jpa;

import com.courseXcelerator.courseXcelerator.core.domain.crawler.Course;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CourseJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "company_id", nullable = false)
    private Long companyId;
    @Column(name = "category_id", nullable = false)
    private Long categoryId;
    @Column(name = "regster_name")
    private String regName;
    @Column(name = "price", nullable = false)
    private String price;
    @Column(name = "img_src", length = 500, nullable = false)
    private String imgSrc;
    @Column(name = "a_href", length = 500, nullable = false)
    private String aHref;

    @Builder
    public CourseJpaEntity(Long id, Long companyId, Long categoryId, String title, String regName, String price, String imgSrc, String aHref) {
        this.id = id;
        this.companyId = companyId;
        this.categoryId = categoryId;
        this.title = title;
        this.regName = regName;
        this.price = price;
        this.imgSrc = imgSrc;
        this.aHref = aHref;
    }


    public static CourseJpaEntity of(Course course) {
        return CourseJpaEntity.builder()
                .title(course.getTitle())
                .companyId(course.getCompanyId())
                .categoryId(course.getCategoryId())
                .regName(course.getRegName())
                .price(course.getPrice())
                .imgSrc(course.getImgSrc())
                .aHref(course.getAHref())
                .build();
    }
}
