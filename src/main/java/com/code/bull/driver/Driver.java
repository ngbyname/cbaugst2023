package com.code.bull.driver;

import com.code.bull.commonutils.actions.BaseActions;
import com.code.bull.commonutils.applicationutils.constants.ApplicationConstants;
import com.code.bull.commonutils.applicationutils.constants.ConstantUtils;
import com.code.bull.commonutils.commonlib.CommonLib;
import com.code.bull.pagerepository.pagemethods.PageCollection;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;

public class Driver {

    public static String env = System.getProperty("env");
    protected static String browser = null;
    protected static String baseUrl;
    public static WebDriver driver;
    public static ConstantUtils constants = ConstantUtils.getInstance();
    public static PageCollection pages;
    public static StringBuilder assertCheck;
    public static final BaseActions actions = new BaseActions();
    public static CommonLib commonLib = new CommonLib();


    private static final Logger log = LogManager.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    /**
     * env =production
     */


    @BeforeSuite
    public void setupEnv() {
        envSetup();
        setBrowser();
    }

    @BeforeClass
    public void pageSetup() {
        try {
            pages = new PageCollection(driver);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @BeforeMethod
    public static void methodLevelSetup() {
        try {
            assertCheck = new StringBuilder();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @AfterMethod
    public static void endTest() {

    }

    @AfterClass
    public void cleanUp() {

    }

    @AfterSuite
    public void close() {
        driver.close();
        if (driver != null) {
            driver.quit();
        }
    }


    private void envSetup() {
        log.info("Going to setup Env");
        browser = constants.getValue(ApplicationConstants.WEB_BROWSER);
        baseUrl = constants.getValue(ApplicationConstants.BASE_URL);
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
                    startBrowser(baseUrl);
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
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    private void startBrowser(String url) {
        driver.get(url);
    }
}