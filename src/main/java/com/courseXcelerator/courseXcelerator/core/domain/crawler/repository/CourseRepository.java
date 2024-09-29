package com.courseXcelerator.courseXcelerator.core.domain.crawler.repository;

import com.courseXcelerator.courseXcelerator.core.domain.crawler.Course;
import com.courseXcelerator.courseXcelerator.storage.jpa.CourseJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseJpaEntity, Long> {
    Optional<List<Course>> findByCompanyIdAndCategoryId(Long companyId, Long categoryId);
}
