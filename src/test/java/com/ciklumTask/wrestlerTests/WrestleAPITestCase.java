package com.ciklumTask.wrestlerTests;

import com.api.WrestlerController;
import com.api.WrestlerModel;
import com.ciklumTask.core.BaseTest;
import org.testng.annotations.Test;

public class WrestleAPITestCase extends BaseTest {

    @Test
    public void testCreateNewWrestlerViaAPI() {
        WrestlerModel testWrestler = new WrestlerModel(
                "aaaaaaa",
                "6",
                "3",
                "2",
                "3",
                "2015",
                "2",
                "25-05-1994",
                "1",
                "2",
                "2",
                "3"
        );
        WrestlerModel wrestlerResponse = new WrestlerController(testWrestler).createNewWrestler();
        softAssert.assertTrue(wrestlerResponse.getResult(), "Wrestler is not created!");
        softAssert.assertAll();
    }
}
