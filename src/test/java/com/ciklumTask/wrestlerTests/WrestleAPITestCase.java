package com.ciklumTask.wrestlerTests;

import com.api.WrestlerController;
import com.api.WrestlerModel;
import com.ciklumTask.core.BaseTest;
import org.testng.annotations.Test;

public class WrestleAPITestCase extends BaseTest {

    @Test
    public void testCreateNewWrestlerViaAPI() {
        String dateOfBirth = "25-05-1994";
        WrestlerModel testWrestler = new WrestlerModel(
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
                String.valueOf(faker.number().numberBetween(1, 3)),
                String.valueOf(faker.number().numberBetween(1, 3)));
        WrestlerModel wrestlerResponse = new WrestlerController(testWrestler).createNewWrestler();
        softAssert.assertTrue(wrestlerResponse.getResult(), "Wrestler is not created! > Result: False");
        softAssert.assertNotNull(wrestlerResponse.getIdWrestler(), "Wrestler ID is Null");
        softAssert.assertAll();
    }
}
