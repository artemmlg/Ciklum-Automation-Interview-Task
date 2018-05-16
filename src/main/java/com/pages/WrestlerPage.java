package com.pages;

import com.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WrestlerPage extends BasePage {

    public WrestlerPage(WebDriver driver) {
        super(driver);
    }

    //Wrestler | Main Grid
    @FindBy(xpath = ".//*[@ng-click='newWrestler()']")
    private WebElement addNewBtn;

    public NewWrestlerTabPage clickNew(){
        waitForElementDisplayed(addNewBtn);
        addNewBtn.click();
        return new NewWrestlerTabPage(driver);
    }
}
