package com.ciklumTask.wrestlerTests;

import com.api.WrestlerModel;
import com.ciklumTask.utils.WrestlerCredentials;
import com.config.AppProperties;
import com.github.javafaker.Faker;
import com.pages.BasePage;
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
    protected WrestlerModel testWrestler;
    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();
    protected Faker faker = new Faker();
    private BasePage basePage;

    @BeforeClass
    public void beforeClass() {
        LOG.info("Driver initialization");
        driver = WebDriverFactory.setWebDriver();
        basePage = new BasePage(driver);
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        testWrestler = new WrestlerModel(
                WrestlerCredentials.FIRST_NAME.getValue(),
                WrestlerCredentials.FIRST_REGION.getValue(),
                WrestlerCredentials.SECOND_REGION.getValue(),
                WrestlerCredentials.YEAR.getValue(),
                WrestlerCredentials.MIDDLE_NAME.getValue(),
                WrestlerCredentials.LAST_NAME.getValue(),
                WrestlerCredentials.AGE.getValue(),
                WrestlerCredentials.DATE_OF_BIRTH.getValue(),
                WrestlerCredentials.LICENCE_TYPE.getValue(),
                WrestlerCredentials.STYLE.getValue(),
                WrestlerCredentials.FIRST_FST.getValue(),
                WrestlerCredentials.SECOND_FST.getValue());

        ///Get current THREAD for Logging
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
