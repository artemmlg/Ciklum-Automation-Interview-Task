package com.ciklumTask.wrestlerTests;

import com.api.WrestlerAPIController;
import com.api.WrestlerModel;
import com.ciklumTask.utils.WrestlerFlexibleCredentials;
import com.ciklumTask.utils.WrestlerStaleCredentials;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class WrestleAPITestSuite {
    private WrestlerFlexibleCredentials flexibleCredentials = new WrestlerFlexibleCredentials();
    private SoftAssert softAssert = new SoftAssert();
    private WrestlerModel testWrestler;
    private WrestlerAPIController wrestlerAPIController;
    private List<String> wrestlerList;

    @BeforeMethod
    public void beforeMethod() {
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

        wrestlerList = Arrays.asList(testWrestler.getFname(), testWrestler.getLname(), testWrestler.getMname(),
                testWrestler.getDob(), testWrestler.getStyle(), testWrestler.getRegion1(), testWrestler.getRegion2(),
                testWrestler.getFst1(), testWrestler.getFst2(), testWrestler.getExpires(), testWrestler.getLictype());
    }

    @Test(description = "CREATE / POST Method")
    public void testCreateNewWrestlerViaAPI() {
        WrestlerModel newWrestler = new WrestlerAPIController(testWrestler).createNewWrestler();
        softAssert.assertTrue(newWrestler.getResult(), "Wrestler is not created! > Result: False");
        softAssert.assertNotNull(newWrestler.getId(), "Wrestler ID is Null");
        softAssert.assertAll();
    }

    @Test(description = "READ / GET Method")
    public void testReadWrestlerViaAPI() {
        wrestlerAPIController = new WrestlerAPIController(testWrestler);
        String getIdFromCreatedWrestler = wrestlerAPIController.createNewWrestler().getId();
        WrestlerModel response = wrestlerAPIController.readWrestler(getIdFromCreatedWrestler);
        List<String> wrestlerListFromApi = Arrays.asList(response.getFname(), response.getLname(), response.getMname(),
                response.getDob(), response.getStyle(), response.getRegion1(), response.getRegion2(),
                response.getFst1(), response.getFst2(), response.getExpires(), response.getLictype());
        for (int i = 0; i < wrestlerListFromApi.size(); i++) {
            softAssert.assertEquals(wrestlerList.get(i), wrestlerListFromApi.get(i));
        }
        softAssert.assertAll();
    }

    @Test(description = "UPDATE / PUT Method")
    public void testUpdateWrestlerViaAPI() {
        wrestlerAPIController = new WrestlerAPIController(testWrestler);
        String getIdFromCreatedWrestler = wrestlerAPIController.createNewWrestler().getId();
        testWrestler.setIdWrestler(getIdFromCreatedWrestler);
        testWrestler.setFname(WrestlerStaleCredentials.FIRST_NAME.getValue());
        testWrestler.setLname(WrestlerStaleCredentials.LAST_NAME.getValue());
        testWrestler.setMname(WrestlerStaleCredentials.MIDDLE_NAME.getValue());
        testWrestler.setDob(WrestlerStaleCredentials.DATE_OF_BIRTH.getValue());
        testWrestler.setFst1(WrestlerStaleCredentials.FIRST_FST.getValue());
        testWrestler.setFst2(WrestlerStaleCredentials.SECOND_FST.getValue());
        testWrestler.setRegion1(WrestlerStaleCredentials.FIRST_REGION.getValue());
        testWrestler.setRegion2(WrestlerStaleCredentials.SECOND_REGION.getValue());
        testWrestler.setLictype(WrestlerStaleCredentials.LICENCE_TYPE.getValue());
        testWrestler.setStyle(WrestlerStaleCredentials.STYLE.getValue());
        testWrestler.setCardState(WrestlerStaleCredentials.AGE.getValue());
        testWrestler.setExpires(WrestlerStaleCredentials.YEAR.getValue());
        WrestlerModel updatedWrestler = wrestlerAPIController.updateWrestler();
        softAssert.assertTrue(updatedWrestler.getResult(), "Wrestler wasn't updated!");
        softAssert.assertAll();
    }

    @Test(description = "DELETE / DELETE Method")
    public void testDeleteWrestlerViaAPI() {
        wrestlerAPIController = new WrestlerAPIController(testWrestler);
        String getIdFromCreatedWrestler = wrestlerAPIController.createNewWrestler().getId();
        boolean isDeleted = wrestlerAPIController.deleteWrestler(getIdFromCreatedWrestler).getResult();
        softAssert.assertTrue(isDeleted);
        softAssert.assertAll();
    }
}
