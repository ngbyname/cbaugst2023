package com.code.bull.pagerepository.pagemethods;

import com.code.bull.pagerepository.pagelocators.LandingPageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LandingPageMethods extends BasePage {

    LandingPageElements pageElements;

    public LandingPageMethods(WebDriver driver) {
        super(driver);
        pageElements = PageFactory.initElements(driver, LandingPageElements.class);
    }

    /**
     * This method is used to get the weather tab text
     *
     * @return the text
     */
    public String getWeatherTabText() {
        return getText(LandingPageElements.weatherDataTab);
    }

    /**
     * This method is used to get the weather tab text
     *
     * @return the text
     */
    public String getWeatherAPIText() {
        return getText(LandingPageElements.weatherAPITab);
    }

}
