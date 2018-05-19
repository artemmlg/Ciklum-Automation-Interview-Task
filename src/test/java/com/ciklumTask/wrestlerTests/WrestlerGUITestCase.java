package com.ciklumTask.wrestlerTests;

import com.api.WrestlerAPIController;
import com.api.WrestlerModel;
import com.ciklumTask.utils.WrestlerFlexibleCredentials;
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
    private WrestlerModel testWrestler;
    private WrestlerFlexibleCredentials flexibleCredentials = new WrestlerFlexibleCredentials();

    @BeforeMethod
    public void beforeMethod() {
        gridPage = new GridPage(driver);
        loginPage = new LoginPage(driver);
        gridPage.openBaseURL();
        //same random initializations, due to API scenario without inheritance
        testWrestler = new WrestlerModel(
                flexibleCredentials.getFirstName(),
                flexibleCredentials.getFirstRegion(),
                flexibleCredentials.getSecondRegion(),
                flexibleCredentials.getYear(),
                flexibleCredentials.getMiddleName(),
                flexibleCredentials.getLastName(),
                flexibleCredentials.getAge(),
                flexibleCredentials.getDateObBirth(),
                flexibleCredentials.getLicence(),
                flexibleCredentials.getStyle(),
                flexibleCredentials.getFirstFST(),
                flexibleCredentials.getSecondFST());
    }

    @Test(description = "CREATE")
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

    @Test(description = "READ and UPDATE")
    public void testUpdateWrestler() {
        WrestlerAPIController wrestlerAPIController = new WrestlerAPIController(testWrestler);
        String getIdFromAPI = wrestlerAPIController.createNewWrestler().getId();
        WrestlerModel response = wrestlerAPIController.readWrestler(getIdFromAPI);

        loginPage.loginToApplication(userLogin, userPassword);
        gridPage = loginPage.clickLoginButton();
        gridPage.searchByValue(response.getLname());
        gridPage.clickSearchButton();
        wrestlerPage = gridPage.clickWrestlerByIdFromSearchPage(getIdFromAPI);
        softAssert.assertTrue(wrestlerPage.getLname().getText().equalsIgnoreCase(response.getLname()));
        softAssert.assertEquals(wrestlerPage.getFname(), response.getFname());
        softAssert.assertEquals(wrestlerPage.getdOfBirth(), response.getDob());
        softAssert.assertEquals(wrestlerPage.getMname(), response.getMname());
        softAssert.assertEquals(wrestlerPage.getRegionFirstDropdown(), response.getRegion1());
        softAssert.assertEquals(wrestlerPage.getRegionSecondDropdown(), response.getRegion2());
        softAssert.assertEquals(wrestlerPage.getFstFirst(), response.getFst1());
        softAssert.assertEquals(wrestlerPage.getFstSecond(), response.getFst2());
        softAssert.assertEquals(wrestlerPage.getStyle(), response.getStyle());
        softAssert.assertEquals(wrestlerPage.getAgeField(), response.getCardState());
        softAssert.assertEquals(wrestlerPage.getYearField(), response.getExpires());
        softAssert.assertEquals(wrestlerPage.getStatusField(), response.getLictype());
        softAssert.assertAll();

    }

}
