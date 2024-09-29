package com.courseXcelerator.courseXcelerator.core.api.v1;

import com.courseXcelerator.courseXcelerator.core.domain.crawler.Course;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.service.CrawlerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class InflearnController {

    private final CrawlerService crawlerService;

    @GetMapping("/crawl-inflearn")
    public void getInflearnCourses() throws IOException {
        crawlerService.getInflearnInfo();
        crawlerService.getFastCapmusInfo();
    }
}
