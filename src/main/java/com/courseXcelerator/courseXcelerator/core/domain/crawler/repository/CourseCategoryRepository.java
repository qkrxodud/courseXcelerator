package com.courseXcelerator.courseXcelerator.core.domain.crawler.repository;

import com.courseXcelerator.courseXcelerator.storage.jpa.CourseCategoryEntity;
import com.courseXcelerator.courseXcelerator.storage.jpa.CourseJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseCategoryRepository extends JpaRepository<CourseCategoryEntity, Long> {
    Optional<List<CourseCategoryEntity>> findAllByCompanyId(Long companyId);
}
