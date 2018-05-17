package com.ciklumtask.guiTests;

import com.api.WrestlerController;
import com.api.WrestlerModel;
import com.ciklumtask.core.BaseTest;
import com.pages.LoginPage;
import com.pages.NewWrestlerTabPage;
import com.pages.WrestlerPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WrestlerTestCase extends BaseTest {
    private WrestlerPage wrestlerPage;
    private NewWrestlerTabPage newWrestlerTabPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        wrestlerPage = new WrestlerPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testCreateNewWrestler() {
        wrestlerPage.openBaseURL();
        loginPage.loginToApplication(userLogin, userPassword);
        wrestlerPage = loginPage.clickLoginButton();
        newWrestlerTabPage = wrestlerPage.clickNew();
        newWrestlerTabPage.fillNewUserForm(
                "Arnold",
                "Swarz",
                "Tor",
                "05121992",
                "Odeska",
                "AR Krym",
                "2",
                "3",
                "V.Klitschko",
                "M.Klitschko",
                "FW",
                "Junior",
                "2013",
                "Produced");
        newWrestlerTabPage.acceptForm();
        softAssert.assertAll();
    }

    @Test
    public void testCreateNewWrestlerViaAPI(){
        WrestlerModel testWrestler = new WrestlerModel(
                "aaaaaaa",
                "6",
                "3",
                "2",
                "3",
                "2015",
                null,
                null,
                "2",
                "25-05-1994",
                "1",
                "2",
                "2",
                "3",
                null,
                null
                );
        WrestlerModel wrestlerResponse = new WrestlerController(testWrestler).createNewWrestler();
//        softAssert.assertTrue(wrestlerResponse.getIdWrestler().contentEquals("1"));
        softAssert.assertAll();
    }

}
