package com.courseXcelerator.courseXcelerator.core.api.v1;

import com.courseXcelerator.courseXcelerator.core.domain.course.service.CourseService;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.Company;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.Course;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.CourseCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CourseApiController {
    private final CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourses(@RequestParam(required = false) Long companyId, @RequestParam(required = false) Long categoryId) {
        List<Course> course = courseService.getCourse(companyId, categoryId);
        return course;
    }

    @GetMapping("/company")
    public List<Company> getCompany() {
        return courseService.getCompany();
    }

    @GetMapping("/course-category")
    public List<CourseCategory> getCategory(@RequestParam(required = false) Long companyId) {
        return courseService.getCategory(companyId);
    }
}
