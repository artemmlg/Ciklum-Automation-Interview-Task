package com.ciklumTask.wrestlerTests;

import com.api.WrestlerAPIController;
import com.api.models.CreateWrestlerModel;
import com.api.models.ReadWrestlerModel;
import com.ciklumTask.core.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WrestleAPITestCase extends BaseTest {
    private CreateWrestlerModel testWrestler;

    @BeforeMethod
    public void beforeMethod() {
        String dateOfBirth = "25-05-1994";
        testWrestler = new CreateWrestlerModel(
                faker.name().firstName(),
                String.valueOf(faker.number().numberBetween(1, 20)),
                String.valueOf(faker.number().numberBetween(1, 20)),
                String.valueOf(faker.number().numberBetween(2013, 2017)),
                faker.name().lastName(),
                faker.name().lastName(),
                String.valueOf(faker.number().numberBetween(1, 3)),
                dateOfBirth,
                String.valueOf(faker.number().numberBetween(1, 3)),
                String.valueOf(faker.number().numberBetween(1, 3)),
                String.valueOf(faker.number().numberBetween(2, 3)),
                String.valueOf(faker.number().numberBetween(2, 3)));
    }

    @Test(description = "CREATE")
    public void testCreateNewWrestlerViaAPI() {
        CreateWrestlerModel wrestlerResponse = new WrestlerAPIController(testWrestler).createNewWrestler();
        softAssert.assertTrue(wrestlerResponse.getResult(), "Wrestler is not created! > Result: False");
        softAssert.assertNotNull(wrestlerResponse.getIdWrestler(), "Wrestler ID is Null");
        softAssert.assertAll();
    }

    @Test(description = "READ")
    public void testReadWrestlerViaAPI() {
        WrestlerAPIController wrestlerAPIController = new WrestlerAPIController(testWrestler);
        String getCreatedWrestlerID = wrestlerAPIController.createNewWrestler().getIdWrestler();
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
        softAssert.assertEquals(testWrestler.getCardState(), readWrestlerModel.getCardState());
        softAssert.assertAll();
    }
}
