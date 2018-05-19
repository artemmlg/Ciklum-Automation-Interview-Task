package com.ciklumTask.wrestlerTests;

import com.pages.LoginPage;
import com.pages.WrestlerTabPage;
import com.pages.GridPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WrestlerGUITestCase extends BaseTest {
    private GridPage gridPage;
    private WrestlerTabPage wrestlerTabPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        gridPage = new GridPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testCreateNewWrestler() {
        gridPage.openBaseURL();
        loginPage.loginToApplication(userLogin, userPassword);
        gridPage = loginPage.clickLoginButton();
        wrestlerTabPage = gridPage.clickNew();
        wrestlerTabPage.fillNewUserForm(
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
        wrestlerTabPage.clickAcceptNewWrestler();
        softAssert.assertAll();
    }

}
