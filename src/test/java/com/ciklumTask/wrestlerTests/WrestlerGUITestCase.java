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

        String valueAttribute = "value";
        softAssert.assertTrue(wrestlerPage.getWrestlerTab().getText().contains(response.getLname()));
        softAssert.assertEquals(wrestlerPage.getLname().getAttribute(valueAttribute), response.getLname());
        softAssert.assertEquals(wrestlerPage.getFname().getAttribute(valueAttribute), response.getFname());
        softAssert.assertEquals(wrestlerPage.getdOfBirth().getAttribute(valueAttribute), response.getDob());
        softAssert.assertEquals(wrestlerPage.getMname().getAttribute(valueAttribute), response.getMname());
        softAssert.assertNotNull(wrestlerPage.getRegionFirstDropdown().get(Integer.parseInt(response.getRegion1())).getText());
        softAssert.assertNotNull(wrestlerPage.getRegionSecondDropdown().get(Integer.parseInt(response.getRegion2())).getText());
        softAssert.assertNotNull(wrestlerPage.getFstFirst().get(Integer.parseInt(response.getFst1())).getText());
        softAssert.assertNotNull(wrestlerPage.getFstSecond().get(Integer.parseInt(response.getFst2())).getText());
        softAssert.assertNotNull(wrestlerPage.getStyle().get(Integer.parseInt(response.getStyle())).getText());
        softAssert.assertNotNull(wrestlerPage.getAgeField().get(Integer.parseInt(response.getCardState())).getText());
        softAssert.assertNotNull(wrestlerPage.getStatusField().get(Integer.parseInt(response.getLictype())).getText());
        softAssert.assertNotNull(wrestlerPage.getYearField().getText());

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
        softAssert.assertTrue(wrestlerPage.getWrestlerTab().getText().contains(WrestlerStaleCredentials.LAST_NAME.getValue()),
                "Wrestler LAST_NAME: " + WrestlerStaleCredentials.LAST_NAME.getValue() + ", wasn't updated on tab!");
        softAssert.assertAll();
    }

    @Test(description = "DELETE")
    public void testDeleteWrestler(){
        WrestlerAPIController wrestlerAPIController = new WrestlerAPIController(testWrestler);
        String getIdFromAPI = wrestlerAPIController.createNewWrestler().getId();
        WrestlerModel response = wrestlerAPIController.readWrestler(getIdFromAPI);

        loginPage.loginToApplication(userLogin, userPassword);
        gridPage = loginPage.clickLoginButton();
        gridPage.searchByValue(response.getLname());
        gridPage.clickSearchButton();
        wrestlerPage = gridPage.clickWrestlerByIdFromSearchPage(getIdFromAPI);
        wrestlerPage.clickDeleteWrestler();
        wrestlerPage.clickConfirmDeleteFromFakeAlert();

        gridPage.searchByValue(response.getLname());
        gridPage.clickSearchButton();

        gridPage.clickWrestlerByIdFromSearchPage(getIdFromAPI);

        softAssert.assertAll();
    }

}
