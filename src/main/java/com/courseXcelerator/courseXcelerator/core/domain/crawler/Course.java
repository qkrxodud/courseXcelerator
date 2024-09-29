package com.courseXcelerator.courseXcelerator.core.domain.crawler;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Course {
    private String title;
    private Long companyId;
    private Long categoryId;
    private String regName;
    private String price;
    private String imgSrc;
    private String aHref;


    @Builder
    public Course(String title, Long companyId, Long categoryId, String regName, String price, String imgSrc, String aHref) {
        this.title = title;
        this.companyId = companyId;
        this.categoryId = categoryId;
        this.regName = regName;
        this.price = price;
        this.imgSrc = imgSrc;
        this.aHref = aHref;
    }

    public static Course of(String title, Long companyId, Long categoryId, String regName, String price, String imgSrc, String aHref) {
        return Course.builder()
                .title(title)
                .companyId(companyId)
                .categoryId(categoryId)
                .regName(regName)
                .price(price)
                .imgSrc(imgSrc)
                .aHref(aHref)
                .build();
    }
}
