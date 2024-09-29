package com.courseXcelerator.courseXcelerator.web.controller;

import com.courseXcelerator.courseXcelerator.core.domain.crawler.Company;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.CourseCategory;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.repository.CompanyRepository;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequiredArgsConstructor
public class HomeController {
    private final CompanyRepository companyRepository;

    @GetMapping("/")
    public ModelAndView homeQuestions() {

        ModelAndView modelAndView = new ModelAndView("home.html");
        return modelAndView;  // questions.html로 이동
    }
}
