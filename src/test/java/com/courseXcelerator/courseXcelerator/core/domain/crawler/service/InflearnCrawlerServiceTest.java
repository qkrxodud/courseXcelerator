package com.courseXcelerator.courseXcelerator.core.domain.crawler.service;

import com.courseXcelerator.courseXcelerator.core.domain.crawler.Course;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles
@SpringBootTest
class InflearnCrawlerServiceTest {

    @Autowired
    private CrawlerService inflearnCrawlerService;

    @Test
    public  void 인프런_테스트 () throws Exception {
        //given
        List<Course> inflearnInfo = inflearnCrawlerService.getInflearnInfo();
        //when
        //then
        Assertions.assertThat(inflearnInfo.size()).isEqualTo(20);
    }

    @Test
    public  void 패스트캠퍼스_테스트 () throws Exception {
        //given
        List<Course> inflearnInfo = inflearnCrawlerService.getFastCapmusInfo();
        //when
        //then
        Assertions.assertThat(inflearnInfo.size()).isEqualTo(20);
    }
}