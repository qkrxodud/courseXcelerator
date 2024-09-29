package com.courseXcelerator.courseXcelerator.core.domain.crawler.service;

import com.courseXcelerator.courseXcelerator.core.domain.crawler.Company;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.Course;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.CourseCategory;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.Courses;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.handler.CrawlerHandler;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.repository.CompanyRepository;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.repository.CourseCategoryRepository;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CrawlerService {
    private final CrawlerHandler crawHandler;
    private final CourseRepository inflearnCrawlerRepository;
    private final CompanyRepository companyRepository;
    private final CourseCategoryRepository courseCategoryRepository;
    public List<Course> getInflearnInfo() throws IOException {
        Company inflearn = companyRepository.findByName("inflearn")
                .orElseThrow(() -> new RuntimeException("회사를 찾을 수 없습니다."))
                .toModel();

        List<CourseCategory> categories = courseCategoryRepository.findAllByCompanyId(inflearn.getId())
                .orElse(Collections.emptyList())
                .stream().map(courseCategoryEntity -> courseCategoryEntity.toModel())
                .collect(Collectors.toList());

        Courses courese = new Courses(crawHandler.fetchInflearnCrawler(inflearn, categories));
        inflearnCrawlerRepository.saveAll(courese.toJapEntities());
        return courese.getCoursesList();
    }

    public List<Course> getFastCapmusInfo() throws IOException {
        Company fastcampus = companyRepository.findByName("fastcampus")
                .orElseThrow(() -> new RuntimeException("회사를 찾을 수 없습니다."))
                .toModel();

        List<CourseCategory> categories = courseCategoryRepository.findAllByCompanyId(fastcampus.getId())
                .orElse(Collections.emptyList())
                .stream().map(courseCategoryEntity -> courseCategoryEntity.toModel())
                .collect(Collectors.toList());

        Courses course = new Courses(crawHandler.fetchFastCampusCrawler(fastcampus, categories));
        inflearnCrawlerRepository.saveAll(course.toJapEntities());
        return course.getCoursesList();
    }
}
