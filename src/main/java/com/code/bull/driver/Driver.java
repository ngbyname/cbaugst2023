package com.code.bull.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

import java.lang.invoke.MethodHandles;

public class Driver {

    protected static String env = System.getProperty("env");
    protected static String browser = System.getProperty("browser");
    public static WebDriver driver;

    private static final Logger log = LogManager.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    /**
     * env =production
     */


    @BeforeSuite
    public void setupEnv() {
        envSetup();
        setBrowser();
    }


    private void envSetup() {
        log.info("Going to setup Env");
        if (env.equalsIgnoreCase("sit")) {
            env = "SIT";
        } else if (env.equalsIgnoreCase("uat")) {
            env = "UAT";
        } else if (env.equalsIgnoreCase("prod")) {
            env = "PROD";
        } else {
            env = "SIT";
        }
    }

    private void setBrowser() {
        try {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    browserCapabilities();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            log.error("Error in setBrowser method and it is :" + e.getMessage());
        }
    }

    private void browserCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1792,1120");
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
}