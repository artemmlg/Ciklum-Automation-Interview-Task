package com.ciklumTask.wrestlerTests;

import com.config.AppProperties;
import com.utils.webDriver.WebDriverFactory;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

public abstract class BaseTest {
    private static AppProperties appProperties = ConfigFactory.create(AppProperties.class);
    static final String userLogin = appProperties.login();
    static final String userPassword = appProperties.password();
    protected Logger LOG = Logger.getLogger(BaseTest.class);

    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void beforeClass() {
        LOG.info("Driver initialization");
        driver = WebDriverFactory.setWebDriver();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        String testName = method.getName();
        Thread.currentThread().setName(testName);
        LOG.info("\nTest Method: " + testName + " <==> From Class: " + this.getClass().getSimpleName() + " is launched!");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
