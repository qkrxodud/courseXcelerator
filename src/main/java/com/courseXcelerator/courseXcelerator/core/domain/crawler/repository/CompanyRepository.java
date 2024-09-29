package com.courseXcelerator.courseXcelerator.core.domain.crawler.repository;

import com.courseXcelerator.courseXcelerator.storage.jpa.CompanyEntity;
import com.courseXcelerator.courseXcelerator.storage.jpa.CourseJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    Optional<CompanyEntity> findByName(String name);
}
