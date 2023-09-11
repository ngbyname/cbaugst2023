package com.code.bull.pagerepository.pagemethods;

import org.openqa.selenium.WebDriver;

public class PageCollection {

    private final WebDriver driver;

    public PageCollection(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPageMethods getLandingPage() {
        return new LandingPageMethods(driver);
    }
}
