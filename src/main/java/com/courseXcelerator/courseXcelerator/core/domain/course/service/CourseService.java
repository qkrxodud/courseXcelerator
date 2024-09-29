package com.courseXcelerator.courseXcelerator.core.domain.course.service;

import com.courseXcelerator.courseXcelerator.core.domain.crawler.Company;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.Course;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.CourseCategory;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.repository.CompanyRepository;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.repository.CourseCategoryRepository;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;
    private final CourseCategoryRepository courseCategoryRepository;

    public List<Course> getCourse(final Long companyId, final Long categoryId) {
        return courseRepository.findByCompanyIdAndCategoryId(companyId, categoryId)
                .orElse(Collections.emptyList());
    }

    public List<Company> getCompany() {
        return companyRepository.findAll()
                .stream()
                .map(companyEntity -> companyEntity.toModel())
                .collect(Collectors.toList());
    }

    public List<CourseCategory> getCategory(final Long companyId) {
        return courseCategoryRepository.findAllByCompanyId(companyId)
                .orElse(Collections.emptyList())
                .stream()
                .map(courseCategoryEntity -> courseCategoryEntity.toModel())
                .collect(Collectors.toList());
    }
}
