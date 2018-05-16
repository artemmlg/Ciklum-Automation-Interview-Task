package com.ciklumtask.core;

import com.config.AppProperties;
import com.core.BasePage;
import com.utils.webDriver.WebDriverFactory;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public abstract class BaseTest {
    private static AppProperties appProperties = ConfigFactory.create(AppProperties.class);
    protected static final String userLogin = appProperties.login();
    protected static final String userPassword = appProperties.password();

    protected WebDriver driver;
    protected SoftAssert softAssert;
    private BasePage basePage;

    @BeforeClass
    public void beforeClass() {
//        LOG.info("Driver initialization");
        driver = WebDriverFactory.setWebDriver();
        basePage = new BasePage(driver);
        softAssert = new SoftAssert();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null){
            driver.quit();
        }
    }

}
