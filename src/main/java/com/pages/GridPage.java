package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GridPage extends BasePage {

    public GridPage(WebDriver driver) {
        super(driver);
    }

    //Wrestler | Main Grid
    @FindBy(xpath = ".//*[@ng-click='newWrestler()']")
    private WebElement addNewBtn;

    public WrestlerPage clickNew(){
        waitForElementDisplayed(addNewBtn);
        addNewBtn.click();
        return new WrestlerPage(driver);
    }
}
