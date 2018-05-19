package com.ciklumTask.wrestlerTests;

import com.pages.BasePage;
import com.pages.GridPage;
import com.pages.LoginPage;
import com.pages.WrestlerPage;
import com.utils.webDriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WrestlerGUITestCase extends BaseTest {
    protected WebDriver driver;
    private GridPage gridPage;
    private WrestlerPage wrestlerPage;
    private LoginPage loginPage;
    private BasePage basePage;

    @BeforeClass
    public void beforeClass() {
        LOG.info("Driver initialization");
        driver = WebDriverFactory.setWebDriver();
        basePage = new BasePage(driver);
        gridPage = new GridPage(driver);
        loginPage = new LoginPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {

        gridPage.openBaseURL();

    }

    @Test (description = "CREATE")
    public void testCreateNewWrestler() {
        loginPage.loginToApplication(userLogin, userPassword);
        gridPage = loginPage.clickLoginButton();
        wrestlerPage = gridPage.clickNew();
        wrestlerPage.addLastName(faker.name().lastName());
        wrestlerPage.addFirstName(faker.name().firstName());
        wrestlerPage.addDateOfBirth("asd");
        wrestlerPage.addMiddleName(faker.name().firstName());
        wrestlerPage.selectFromFirstRegion("2");
//        wrestlerPage.selectFromSecondRegion("2");
//        wrestlerPage.selectFromFristFST("2");
//        wrestlerPage.selectFromSecondFST("2");
        wrestlerPage.addFirstTrainer(faker.gameOfThrones().character());
        wrestlerPage.addSecondTrainer(faker.lordOfTheRings().character());
//        wrestlerPage.selectFromStyle("2");
//        wrestlerPage.selectFromAge("2");
//        wrestlerPage.selectFromYear(String.valueOf(faker.number().numberBetween(2013, 2017)));
//        wrestlerPage.selectFromStatus("2");
        wrestlerPage.clickAcceptNewWrestler();
        softAssert.assertTrue(wrestlerPage.getPhotoPanel().getText().contentEquals("Photo"));
        softAssert.assertTrue(wrestlerPage.getDocumentsPanel().getText().contentEquals("Documents"));
        softAssert.assertAll();
    }

}
