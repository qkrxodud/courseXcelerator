package com.courseXcelerator.courseXcelerator.core.domain.crawler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WebElements {
    private static final String INFLEARN_LECTURE_TITLE = ".mantine-b3zn22";
    private static final String INFLEARN_LECTURE_REGISTER_NAME = ".mantine-Text-root.css-1r49xhh.mantine-aiouth";
    private static final String INFLEARN_LECTURE_PRICE = ".mantine-cm9qo8";

    private static final String FASTCAMPUS_LECTURE_TITLE = ".CourseCard_courseCardTitle__1HQgO";
    private static final String FASTCAMPUS_LECTURE_PRICE = ".CourseCard_courseCardPrice__dbuVW";
    private static final String IMG_TAG = "img";
    private static final String SRC_TAG = "src";
    private static final String A_TAG = "a";
    private static final String HREF_TAG = "href";
    private List<WebElement> webElements;

    public WebElements(List<WebElement> webElements) {
        this.webElements = webElements;
    }

    public List<Course> getInflearnCrawler(final Long inflreanId, final Long courseCategoryId) {
        List<Course> inflearnCrawlerList = new ArrayList<>();
        for (WebElement element : webElements) {
            Course of = Course.of(getInflearnTitle(element), inflreanId, courseCategoryId, getInflearnRegName(element), getInflearnPrice(element), getImgSrc(element), getAHref(element));
            inflearnCrawlerList.add(of);
        }
        return inflearnCrawlerList;
    }

    private String getInflearnTitle(WebElement element) {
        return element.findElement(By.cssSelector(INFLEARN_LECTURE_TITLE))
                .getText();
    }

    private String getInflearnRegName(WebElement element) {
        return element.findElement(By.cssSelector(INFLEARN_LECTURE_REGISTER_NAME))
                .getText();
    }

    private String getInflearnPrice(WebElement element) {
        String price;
        try {
            price = element.findElement(By.cssSelector(INFLEARN_LECTURE_PRICE))
                    .getText();
        } catch (RuntimeException runtimeException) {
            price = "무료";
        }
        return price;
    }

    private String getImgSrc(WebElement element) {
        String attribute = element.findElement(By.tagName(IMG_TAG))
                .getAttribute(SRC_TAG);
        return attribute;
    }

    private String getAHref(WebElement element) {
        String attribute = element.findElement(By.tagName(A_TAG))
                .getAttribute(HREF_TAG);
        return attribute;
    }

    public List<Course> getFastCampusCrawler(final Long fastcampusId, final Long courseCategoryId) {
        List<Course> fastcampusCourse = new ArrayList<>();
        for (WebElement element : webElements) {
            Course of = Course.of(getFastCampusTitle(element), fastcampusId, courseCategoryId, null, getFastCampusPrice(element), getImgSrc(element), getAHref(element));
            fastcampusCourse.add(of);
        }
        return fastcampusCourse;
    }

    private String getFastCampusTitle(WebElement element) {
        String text = element.findElement(By.cssSelector(FASTCAMPUS_LECTURE_TITLE))
                .getText();
        return text;
    }

    private String getFastCampusPrice(WebElement element) {
        String price;
        try {
            price = element.findElement(By.cssSelector(FASTCAMPUS_LECTURE_PRICE))
                    .getText();
        } catch (RuntimeException runtimeException) {
            price = "무료";
        }
        return price;
    }
}
