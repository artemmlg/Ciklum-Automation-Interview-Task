package com.ciklumTask.wrestlerTests;

import com.api.WrestlerAPIController;
import com.api.WrestlerModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WrestleAPITestCase extends BaseTest {
    private WrestlerModel testWrestler;
    private WrestlerAPIController wrestlerAPIController;

    @BeforeMethod
    public void beforeMethod() {
        String dateOfBirth = "25-05-1994";
        testWrestler = new WrestlerModel(
                faker.gameOfThrones().character(),
                String.valueOf(faker.number().numberBetween(2, 20)),
                String.valueOf(faker.number().numberBetween(2, 20)),
                String.valueOf(faker.number().numberBetween(2013, 2017)),
                faker.harryPotter().character(),
                faker.gameOfThrones().character(),
                String.valueOf(faker.number().numberBetween(2, 3)),
                dateOfBirth,
                String.valueOf(faker.number().numberBetween(2, 3)),
                String.valueOf(faker.number().numberBetween(2, 3)),
                String.valueOf(faker.number().numberBetween(2, 7)),
                String.valueOf(faker.number().numberBetween(2, 7)));
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
        softAssert.assertEquals(testWrestler.getFname(), response.getFname());
        softAssert.assertEquals(testWrestler.getLname(), response.getLname());
        softAssert.assertEquals(testWrestler.getMname(), response.getMname());
        softAssert.assertEquals(testWrestler.getDob(), response.getDob());
        softAssert.assertEquals(testWrestler.getStyle(), response.getStyle());
        softAssert.assertEquals(testWrestler.getRegion1(), response.getRegion1());
        softAssert.assertEquals(testWrestler.getRegion2(), response.getRegion2());
        softAssert.assertEquals(testWrestler.getFst1(), response.getFst1());
        softAssert.assertEquals(testWrestler.getFst2(), response.getFst2());
        softAssert.assertEquals(testWrestler.getExpires(), response.getExpires());
        softAssert.assertEquals(testWrestler.getLictype(), response.getLictype());
        softAssert.assertAll();
    }

    @Test(description = "UPDATE / PUT Method")
    public void testUpdateWrestlerViaAPI() {
        String addition = String.valueOf(System.currentTimeMillis());
        wrestlerAPIController = new WrestlerAPIController(testWrestler);
        String getIdFromCreatedWrestler = wrestlerAPIController.createNewWrestler().getId();
        testWrestler.setIdWrestler(getIdFromCreatedWrestler);
        testWrestler.setFname("updatedFirstName" + addition);
        testWrestler.setLname("updatedLastName" + addition);
        testWrestler.setMname("updatedMiddleName" + addition);
        testWrestler.setDob("25-05-2000");
        testWrestler.setFst1("3");
        testWrestler.setFst2("3");
        testWrestler.setRegion1("3");
        testWrestler.setRegion2("3");
        testWrestler.setLictype("3");
        testWrestler.setStyle("3");
        testWrestler.setCardState("3");
        testWrestler.setExpires("2013");
        WrestlerModel updatedWrestler = wrestlerAPIController.updateWrestler();
        softAssert.assertTrue(updatedWrestler.getResult(), "Wrestler wasn't updated!");
        softAssert.assertAll();
    }

    @Test(description ="DELETE / DELETE Method")
    public void testDeleteWrestlerViaAPI(){
        wrestlerAPIController = new WrestlerAPIController(testWrestler);
        String getIdFromCreatedWrestler = wrestlerAPIController.createNewWrestler().getId();
        boolean isDeleted = wrestlerAPIController.deleteWrestler(getIdFromCreatedWrestler).getResult();
        softAssert.assertTrue(isDeleted);
        softAssert.assertAll();
    }
}
