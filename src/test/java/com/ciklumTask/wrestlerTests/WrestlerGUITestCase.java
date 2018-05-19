package com.ciklumTask.wrestlerTests;

import com.ciklumTask.utils.WrestlerStaleCredentials;
import com.pages.GridPage;
import com.pages.LoginPage;
import com.pages.WrestlerPage;
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
        loginPage.loginToApplication(userLogin, userPassword);
        gridPage = loginPage.clickLoginButton();
        wrestlerPage = gridPage.clickNew();
        wrestlerPage.addLastName(WrestlerStaleCredentials.LAST_NAME.getValue());
        wrestlerPage.addFirstName(WrestlerStaleCredentials.FIRST_NAME.getValue());
        wrestlerPage.addDateOfBirth(WrestlerStaleCredentials.DATE_OF_BIRTH.getValue());
        wrestlerPage.addMiddleName(WrestlerStaleCredentials.MIDDLE_NAME.getValue());
        wrestlerPage.selectFromFirstRegion(WrestlerStaleCredentials.FIRST_REGION.getValue());
        wrestlerPage.selectFromSecondRegion(WrestlerStaleCredentials.SECOND_REGION.getValue());
        wrestlerPage.selectFromFristFST(WrestlerStaleCredentials.FIRST_FST.getValue());
        wrestlerPage.selectFromSecondFST(WrestlerStaleCredentials.SECOND_FST.getValue());
        wrestlerPage.addFirstTrainer(WrestlerStaleCredentials.FIRST_TRAINER.getValue());
        wrestlerPage.addSecondTrainer(WrestlerStaleCredentials.SECOND_TRAINER.getValue());
        wrestlerPage.selectFromStyle(WrestlerStaleCredentials.STYLE.getValue());
        wrestlerPage.selectFromAge(WrestlerStaleCredentials.AGE.getValue());
        wrestlerPage.selectFromYear(WrestlerStaleCredentials.YEAR.getValue());
        wrestlerPage.selectFromStatus(WrestlerStaleCredentials.LICENCE_TYPE.getValue());
        wrestlerPage.clickAcceptNewWrestler();
        softAssert.assertTrue(wrestlerPage.getPhotoPanel().getText().contentEquals("Photo"));
        softAssert.assertTrue(wrestlerPage.getDocumentsPanel().getText().contentEquals("Documents"));
        softAssert.assertAll();
    }

}
