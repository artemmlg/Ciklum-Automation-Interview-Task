package com.ciklumTask.core;

import com.config.AppProperties;
import com.core.BasePage;
import com.github.javafaker.Faker;
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
    protected Faker faker;
    protected static final String userLogin = appProperties.login();
    protected static final String userPassword = appProperties.password();
    protected Logger LOG = Logger.getLogger(BaseTest.class);

    protected WebDriver driver;
    protected SoftAssert softAssert;
    private BasePage basePage;

    @BeforeClass
    public void beforeClass() {
        LOG.info("Driver initialization");
//        driver = WebDriverFactory.setWebDriver();
        basePage = new BasePage(driver);
        softAssert = new SoftAssert();
        faker = new Faker();
    }

    @BeforeMethod
    public void beforeMethod(Method method){
        String testName = method.getName();
        Thread.currentThread().setName(testName);
        LOG.info("\nTest Method: " + testName + " <==> From Class: " + this.getClass().getSimpleName() + " is launched!");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null){
            driver.quit();
        }
    }

}
