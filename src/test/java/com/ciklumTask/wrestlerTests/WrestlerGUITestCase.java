package com.ciklumTask.wrestlerTests;

import com.github.javafaker.Faker;
import com.pages.GridPage;
import com.pages.LoginPage;
import com.pages.WrestlerPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WrestlerGUITestCase extends BaseTest {
    private GridPage gridPage;
    private WrestlerPage wrestlerPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        gridPage = new GridPage(driver);
        loginPage = new LoginPage(driver);
        gridPage.openBaseURL();
    }

    @Test
    public void testCreateNewWrestler() {
        loginPage.loginToApplication(userLogin, userPassword);
        gridPage = loginPage.clickLoginButton();
        wrestlerPage = gridPage.clickNew();
        wrestlerPage.addLastName(WrestlerCredentials.LAST_NAME.getValue());
        wrestlerPage.addFirstName(WrestlerCredentials.FIRST_NAME.getValue());
        wrestlerPage.addDateOfBirth(WrestlerCredentials.DATE_OF_BIRTH.getValue());
        wrestlerPage.addMiddleName(WrestlerCredentials.MIDDLE_NAME.getValue());
        wrestlerPage.selectFromFirstRegion(WrestlerCredentials.FIRST_REGION.getValue());
        wrestlerPage.selectFromSecondRegion(WrestlerCredentials.SECOND_REGION.getValue());
        wrestlerPage.selectFromFristFST(WrestlerCredentials.FIRST_FST.getValue());
        wrestlerPage.selectFromSecondFST(WrestlerCredentials.SECOND_FST.getValue());
        wrestlerPage.addFirstTrainer(WrestlerCredentials.FIRST_TRAINER.getValue());
        wrestlerPage.addSecondTrainer(WrestlerCredentials.SECOND_TRAINER.getValue());
        wrestlerPage.selectFromStyle(WrestlerCredentials.STYLE.getValue());
        wrestlerPage.selectFromAge(WrestlerCredentials.AGE.getValue());
        wrestlerPage.selectFromYear(WrestlerCredentials.YEAR.getValue());
        wrestlerPage.selectFromStatus(WrestlerCredentials.LICENCE_TYPE.getValue());
        wrestlerPage.clickAcceptNewWrestler();
        softAssert.assertTrue(wrestlerPage.getPhotoPanel().getText().contentEquals("Photo"));
        softAssert.assertTrue(wrestlerPage.getDocumentsPanel().getText().contentEquals("Documents"));
        softAssert.assertAll();
    }

    public enum WrestlerCredentials {
        LAST_NAME(Faker.instance().harryPotter().character()),
        FIRST_NAME(Faker.instance().gameOfThrones().character()),
        DATE_OF_BIRTH(String.valueOf(
                        Faker.instance().number().numberBetween(10, 31)
                        + "-" +
                        Faker.instance().number().numberBetween(10, 12)
                        + "-" +
                        Faker.instance().number().numberBetween(1970, 2018))
        ),
        MIDDLE_NAME(Faker.instance().harryPotter().character()),
        FIRST_REGION(String.valueOf(Faker.instance().number().numberBetween(2, 20))),
        SECOND_REGION(String.valueOf(Faker.instance().number().numberBetween(2, 20))),
        FIRST_FST(String.valueOf(Faker.instance().number().numberBetween(2, 6))),
        SECOND_FST(String.valueOf(Faker.instance().number().numberBetween(2, 6))),
        FIRST_TRAINER(Faker.instance().lordOfTheRings().character()),
        SECOND_TRAINER(Faker.instance().lordOfTheRings().character()),
        STYLE(String.valueOf(Faker.instance().number().numberBetween(2, 3))),
        AGE(String.valueOf(Faker.instance().number().numberBetween(2, 3))),
        YEAR(String.valueOf(Faker.instance().number().numberBetween(2013, 2017))),
        LICENCE_TYPE(String.valueOf(Faker.instance().number().numberBetween(2, 3)));

        private String value;

        WrestlerCredentials(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
