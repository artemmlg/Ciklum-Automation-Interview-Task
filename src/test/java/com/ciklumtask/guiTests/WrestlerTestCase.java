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

    @Test
    public void testCreateNewWrestlerViaAPI(){
        WrestlerModel testWrestler = new WrestlerModel(
                "Ivan",
                "11",
                "10",
                "2015",
                "Sidorovich",
                "Petrov",
                "Petruk P.P.",
                "Ivanuk V.V.",
                "V.1",
                "25-05-1994",
                "1",
                "34",
                "1",
                "2",
                "6",
                "91"
                );
        WrestlerModel wrestlerResponse = new WrestlerController(testWrestler).createNewWrestler();
        softAssert.assertTrue(wrestlerResponse.getFname().contentEquals("Artem"));
    }

}
