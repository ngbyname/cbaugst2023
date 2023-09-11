package com.code.bull.pagerepository.pagemethods;

import com.code.bull.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage extends Driver {

    public BasePage(WebDriver driver){
        Driver.driver=driver;
    }

    /**
     * This method is used to get the text
     *
     * @param webElement the address of the webElement
     * @return the text
     */
    public String getText(By webElement) {
        String value = null;
        if (Boolean.TRUE.equals(isDisplayed(webElement))) {
            value = driver.findElement(webElement).getText();
        } else {
            commonLib.error("Web element is not displayed, so can not get the text");
        }
        return value;
    }

    /**
     * This method is used to click on any webElement
     *
     * @param webElement the address of the webElement
     */
    public void click(By webElement) {
        if (Boolean.TRUE.equals(isDisplayed(webElement))) {
            driver.findElement(webElement).click();
        } else {
            commonLib.error("Web element is not displayed, so can not do the click operation");
        }
    }

    /**
     * This method is used to enter text
     *
     * @param webElement the address of the webElement
     * @param text       the text
     */
    public void enterText(By webElement, String text) {
        if (Boolean.TRUE.equals(isDisplayed(webElement))) {
            driver.findElement(webElement).clear();
            driver.findElement(webElement).sendKeys(text);
        } else {
            commonLib.error("Web element is not displayed, so can not enter the text");
        }
    }

    /**
     * This method is used to find if web element is displayed or not
     *
     * @param webElement the address of the webElement
     * @return boolean value
     */
    public Boolean isDisplayed(By webElement) {
        return driver.findElement(webElement).isDisplayed();
    }
}
