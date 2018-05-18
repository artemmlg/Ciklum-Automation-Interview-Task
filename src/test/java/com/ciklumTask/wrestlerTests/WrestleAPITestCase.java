package com.ciklumTask.wrestlerTests;

import com.api.WrestlerAPIController;
import com.api.models.CreateWrestlerModel;
import com.api.models.ReadWrestlerModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WrestleAPITestCase extends BaseTest {
    private CreateWrestlerModel testWrestler;
    private WrestlerAPIController wrestlerAPIController;

    @BeforeMethod
    public void beforeMethod() {
        String dateOfBirth = "25-05-1994";
        testWrestler = new CreateWrestlerModel(
                faker.name().firstName(),
                String.valueOf(faker.number().numberBetween(2, 20)),
                String.valueOf(faker.number().numberBetween(2, 20)),
                String.valueOf(faker.number().numberBetween(2013, 2017)),
                faker.name().lastName(),
                faker.name().lastName(),
                String.valueOf(faker.number().numberBetween(2, 3)),
                dateOfBirth,
                String.valueOf(faker.number().numberBetween(2, 3)),
                String.valueOf(faker.number().numberBetween(2, 3)),
                String.valueOf(faker.number().numberBetween(2, 3)),
                String.valueOf(faker.number().numberBetween(2, 3)));
    }

    @Test(description = "CREATE / POST Method")
    public void testCreateNewWrestlerViaAPI() {
        CreateWrestlerModel wrestlerResponse = new WrestlerAPIController(testWrestler).createNewWrestler();
        softAssert.assertTrue(wrestlerResponse.getResult(), "Wrestler is not created! > Result: False");
        softAssert.assertNotNull(wrestlerResponse.getId(), "Wrestler ID is Null");
        softAssert.assertAll();
    }

    @Test(description = "READ / GET Method")
    public void testReadWrestlerViaAPI() {
        wrestlerAPIController = new WrestlerAPIController(testWrestler);
        String getCreatedWrestlerID = wrestlerAPIController.createNewWrestler().getId();
        ReadWrestlerModel readWrestlerModel = wrestlerAPIController.readWrestler(getCreatedWrestlerID);
        softAssert.assertEquals(testWrestler.getFname(), readWrestlerModel.getFname());
        softAssert.assertEquals(testWrestler.getLname(), readWrestlerModel.getLname());
        softAssert.assertEquals(testWrestler.getMname(), readWrestlerModel.getMname());
        softAssert.assertEquals(testWrestler.getDob(), readWrestlerModel.getDob());
        softAssert.assertEquals(testWrestler.getStyle(), readWrestlerModel.getStyle());
        softAssert.assertEquals(testWrestler.getRegion1(), readWrestlerModel.getRegion1());
        softAssert.assertEquals(testWrestler.getRegion2(), readWrestlerModel.getRegion2());
        softAssert.assertEquals(testWrestler.getFst1(), readWrestlerModel.getFst1());
        softAssert.assertEquals(testWrestler.getFst2(), readWrestlerModel.getFst2());
        softAssert.assertEquals(testWrestler.getExpires(), readWrestlerModel.getExpires());
        softAssert.assertEquals(testWrestler.getLictype(), readWrestlerModel.getLictype());
        softAssert.assertAll();
    }

    @Test(description = "UPDATE / PUT Method")
    public void testUpdateWrestlerViaAPI() {
        String addition = String.valueOf(System.currentTimeMillis());
        wrestlerAPIController = new WrestlerAPIController(testWrestler);
        String getCreatedWrestlerID = wrestlerAPIController.createNewWrestler().getId();
        testWrestler.setIdWrestler(getCreatedWrestlerID);
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
        CreateWrestlerModel wrestlerResponse = wrestlerAPIController.updateWrestler();
        softAssert.assertTrue(wrestlerResponse.getResult(), "Wrestler wasn't updated!");
        softAssert.assertAll();
    }

    @Test(description ="DELETE / DELETE Method")
    public void testDeleteWrestlerViaAPI(){
        wrestlerAPIController = new WrestlerAPIController(testWrestler);
        String getCreatedWrestlerID = wrestlerAPIController.createNewWrestler().getId();
        boolean isDeleted = wrestlerAPIController.deleteWrestler(getCreatedWrestlerID).getResult();
        softAssert.assertTrue(isDeleted);
        softAssert.assertAll();
    }
}
