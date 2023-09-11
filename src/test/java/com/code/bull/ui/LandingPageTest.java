package com.code.bull.ui;

import com.code.bull.driver.Driver;
import org.testng.annotations.Test;

public class LandingPageTest extends Driver {

    /**
     * 1. First we will divide the pages
     * 2. We have to write the manual test case
     * 3. Test case review
     * 4. you will be added as contributor in Code bull repo
     * 5. then you will start adding new test case (page identify, locators, methods, test case)
     */

    /*
    Pending items
    1. Oops concentps
    2. testng ke kuch parameter
     */
    @Test
    public void test() {
        String weatherTabText = pages.getLandingPage().getWeatherTabText();
        assertCheck.append(actions.assertEqualsString(weatherTabText, "Weather Data", "Weather Data tab text matched successfully", "Weather Data tab text NOT matched"));
        String weatherAPIText = pages.getLandingPage().getWeatherAPIText();
        assertCheck.append(actions.assertEqualsString(weatherAPIText, "Weather API", "Weather API tab text matched successfully", "Weather API tab text NOT matched"));
        actions.checkAllAssert(assertCheck);
    }
}
