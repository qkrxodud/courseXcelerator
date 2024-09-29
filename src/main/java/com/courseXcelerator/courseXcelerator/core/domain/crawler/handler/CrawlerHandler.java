package com.courseXcelerator.courseXcelerator.core.domain.crawler.handler;

import com.courseXcelerator.courseXcelerator.core.domain.crawler.Company;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.Course;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.CourseCategory;
import com.courseXcelerator.courseXcelerator.core.domain.crawler.WebElements;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Slf4j
public class CrawlerHandler {
    private static final Long[] page = {1L, 2L, 3L};
    private static final String INFLEARN_URL_TEMPLATE = "https://www.inflearn.com/courses?types=ONLINE&sort=POPULAR&page_number=%d&skill=%s";
    private static final String INFLEARN_LECTURE_SRC = ".css-8atqhb.mantine-1avyp1d"; // fastCampas
    private static final String FASTFAMPUS_URL_TEMPLATE = "https://fastcampus.co.kr/%s";
    private static final String FASTFAMPUS_LECTURE_SRC = ".CourseCard_basicType__XWiBm";
    private static final Integer RANDOM_INT = new Random().nextInt(4000) + 1000;

    public List<Course> fetchInflearnCrawler(final Company inflearn, final List<CourseCategory> categories) throws IOException {
        List<Course> courses = new ArrayList<>();

        // WebDriverManager를 사용하여 FirefoxDriver 설정
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless"); // 브라우저 창을 열지 않고 실행
        WebDriver driver = new FirefoxDriver(options);
        for (CourseCategory category : categories) {
            for (Long pageNum : page) {
                String url = String.format(INFLEARN_URL_TEMPLATE, pageNum, category.getName());
                try {
                    driver.get(url);
                    List<WebElement> listItems = driver.findElements(By.cssSelector(INFLEARN_LECTURE_SRC));
                    WebElements webElements = new WebElements(listItems);

                    courses.addAll(webElements.getInflearnCrawler(inflearn.getId(), category.getId()));
                    Thread.sleep(RANDOM_INT);
                } catch (RuntimeException | InterruptedException re) {
                    log.error("CrawlerHandler >> fetchCourses {}", re.getMessage());
                }
            }
        }

        driver.quit();

        return courses;
    }

    public List<Course> fetchFastCampusCrawler(final Company fastcampus, final List<CourseCategory> categories) throws IOException {
        List<Course> courses = new ArrayList<>();

        // WebDriverManager를 사용하여 FirefoxDriver 설정
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless"); // 브라우저 창을 열지 않고 실행
        WebDriver driver = new FirefoxDriver(options);

        for (CourseCategory category : categories) {
            String categoryUrl = String.format(FASTFAMPUS_URL_TEMPLATE, category.getName());
            try {
                driver.get(categoryUrl);

                List<WebElement> listItems = driver.findElements(By.cssSelector(FASTFAMPUS_LECTURE_SRC));
                WebElements webElements = new WebElements(listItems);
                courses.addAll(webElements.getFastCampusCrawler(fastcampus.getId(), category.getId()));

                Thread.sleep(RANDOM_INT);
            } catch (RuntimeException | InterruptedException re) {
                log.error("CrawlerHandler >> fetchCourses {}", re.getMessage());
            }
        }
        driver.quit();

        return courses;
    }

}
