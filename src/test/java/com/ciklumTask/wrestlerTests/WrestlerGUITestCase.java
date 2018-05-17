package com.ciklumTask.wrestlerTests;

import com.pages.LoginPage;
import com.pages.NewWrestlerTabPage;
import com.pages.WrestlerPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WrestlerGUITestCase extends BaseTest {
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

}
