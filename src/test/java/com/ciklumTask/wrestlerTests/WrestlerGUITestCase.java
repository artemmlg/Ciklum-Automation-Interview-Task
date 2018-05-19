package com.ciklumTask.wrestlerTests;

import com.pages.LoginPage;
import com.pages.WrestlerPage;
import com.pages.GridPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WrestlerGUITestCase extends BaseTest {
    private GridPage gridPage;
    private WrestlerPage wrestlerPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        gridPage = new GridPage(driver);
        loginPage = new LoginPage(driver);
        gridPage.openBaseURL();
    }

    @Test
    public void testCreateNewWrestler() {
        String dateOfBirth = "05-12-1992";
        loginPage.loginToApplication(userLogin, userPassword);
        gridPage = loginPage.clickLoginButton();
        wrestlerPage = gridPage.clickNew();
        wrestlerPage.addLastName(faker.name().lastName());
        wrestlerPage.addFirstName(faker.name().firstName());
        wrestlerPage.addDateOfBirth(dateOfBirth);
        wrestlerPage.addMiddleName(faker.name().firstName());
        wrestlerPage.selectFromFristRegion("AR Krym");
        wrestlerPage.selectFromSecondRegion("Sevastopol");
        wrestlerPage.selectFromFristFST("Spartak");
        wrestlerPage.selectFromSecondFST("SK");
        wrestlerPage.addFirstTrainer(faker.gameOfThrones().character());
        wrestlerPage.addSecondTrainer(faker.lordOfTheRings().character());
        wrestlerPage.selectFromStyle("GR");
        wrestlerPage.selectFromAge("Cadet");
        wrestlerPage.selectFromYear(String.valueOf(faker.number().numberBetween(2013,2017)));
        wrestlerPage.selectFromStatus("Recieved");
        wrestlerPage.clickAcceptNewWrestler();
        softAssert.assertTrue(wrestlerPage.getPhotoPanel().getText().contentEquals("Photo"));
        softAssert.assertTrue(wrestlerPage.getDocumentsPanel().getText().contentEquals("Documents"));
        softAssert.assertAll();
    }

}
