package com.ciklumtask.guiTests;

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
        wrestlerPage.openBaseURL();
    }

    @Test
    public void testCreateNewWrestler() {
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
                "Kolos",
                "SK",
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
